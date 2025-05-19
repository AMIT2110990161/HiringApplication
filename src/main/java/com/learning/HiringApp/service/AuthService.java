package com.learning.HiringApp.service;

import com.learning.HiringApp.security.authDto.userlogin.AuthRequest;
import com.learning.HiringApp.security.authDto.userlogin.AuthResponse;
import com.learning.HiringApp.security.authDto.registerrequest.RegisterRequest;
import com.learning.HiringApp.security.authDto.registerrequest.RegisterResponse;
import com.learning.HiringApp.security.authEntity.User;
import com.learning.HiringApp.security.authMapper.UserMapper;
import com.learning.HiringApp.security.jwt.JwtUtil;
import com.learning.HiringApp.repository.UserDetailsRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;


    public AuthService(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil, UserMapper userMapper) {
        this.userDetailsRepository = userDetailsRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.userMapper = userMapper;
    }

    public RegisterResponse register(RegisterRequest request) {
        User user = userMapper.toUser(request);

        if (user.getRole() == null) {
            user.setRole("USER");
        }

        // make sure we encode *before* saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User saved = userDetailsRepository.save(user);
        return new RegisterResponse(saved.getId(), saved.getEmail(), "Registration successful");
    }


    public AuthResponse login(AuthRequest authRequest) {
        User user = userDetailsRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }
}