package com.hiringapp.utils.authDto;

public record VerifyOtpRequest(
        String email,
        String otp) {
}
