package com.learning.HiringApp.security.config;

import com.learning.HiringApp.security.authEntity.User;
import com.learning.HiringApp.security.jwt.JwtAuthFilter;
import com.learning.HiringApp.repository.UserDetailsRepository;
import com.learning.HiringApp.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class JwtSecurityConfig {
    private final CustomUserDetailService customUserDetailsService;
    private final UserDetailsRepository userDetailsRepository;
    private final JwtAuthFilter jwtAuthFilter;

    @Value("${admin.email}")
    private String adminEmail;
    @Value("${admin.password}")
    private String adminPassword;

    public JwtSecurityConfig(final CustomUserDetailService customUserDetailsService,
                             final UserDetailsRepository userDetailsRepository,
                             final JwtAuthFilter jwtAuthFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.userDetailsRepository = userDetailsRepository;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean(name = "jwtSecurityFilterChain")
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authReq -> authReq
                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/api/candidates/**").hasRole("ADMIN")
                                .requestMatchers("/api/documents/**").hasRole("USER")
                                .anyRequest().authenticated())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authProvider);
    }


    @Bean
    public CommandLineRunner createAdmin(PasswordEncoder passwordEncoder) {
        return args -> {
            if (userDetailsRepository.findByEmail(adminEmail).isEmpty()) {
                User admin = new User();
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                admin.setRole("ADMIN");
                userDetailsRepository.save(admin);
            }
        };
    }

}