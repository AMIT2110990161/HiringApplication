package com.hiringapp.model.authDto;

public record VerifyOtpResponse(
        boolean success,
        String token
) {
}