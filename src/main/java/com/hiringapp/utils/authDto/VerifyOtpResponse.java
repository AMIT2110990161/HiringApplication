package com.hiringapp.utils.authDto;

public record VerifyOtpResponse(
        boolean success,
        String token
) {
}
