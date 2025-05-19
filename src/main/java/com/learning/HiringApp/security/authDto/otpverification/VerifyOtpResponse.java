package com.learning.HiringApp.security.authDto.otpverification;

public record VerifyOtpResponse(
        boolean success,
        String token
) {
}