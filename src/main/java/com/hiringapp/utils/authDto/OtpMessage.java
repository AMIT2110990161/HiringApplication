package com.hiringapp.utils.authDto;

public record OtpMessage(
        String exchange,
        String routingKey,
        String email,
        String otp
) {
}
