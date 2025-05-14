package com.hiringapp.controller;

import com.hiringapp.service.AuthService;
import com.hiringapp.utils.authDto.*;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid final AuthRequest authRequest) {
        AuthResponse authResponse = authService.login(authRequest);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid final RegisterRequest registerRequest) {
        RegisterResponse registerResponse = authService.register(registerRequest);
        return new ResponseEntity<>(registerResponse, HttpStatus.OK);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<VerifyOtpResponse> verifyOtp(@RequestBody @Valid final VerifyOtpRequest verifyOtpRequest) {
        VerifyOtpResponse verifyOtpResponse = authService.verifyOtp(verifyOtpRequest);
        return new ResponseEntity<>(verifyOtpResponse, HttpStatus.OK);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody @Valid final ForgotPasswordRequest forgotPasswordReq) {
        return new ResponseEntity<>(authService.forgetPassword(forgotPasswordReq), HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Boolean> resetPassword(@RequestBody @Valid final ResetPasswordRequest resetPasswordReq) {
        return new ResponseEntity<>(authService.resetPassword(resetPasswordReq), HttpStatus.OK);
    }
}
