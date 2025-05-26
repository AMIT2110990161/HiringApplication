package com.hiringapp.model.authDto;

public record VerifyOtpRequest(
        String email,
        String otp
) {
}