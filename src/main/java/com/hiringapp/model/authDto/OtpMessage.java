package com.hiringapp.model.authDto;

public record OtpMessage(
        String exchange,
        String routingKey,
        String email,
        String otp
) {
}