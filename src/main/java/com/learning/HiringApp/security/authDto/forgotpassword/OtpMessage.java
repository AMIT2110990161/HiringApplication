package com.learning.HiringApp.security.authDto.forgotpassword;


import lombok.Data;

@Data

public class OtpMessage {
    private String to;
    private String otp;
    private String routingKey;
    private String exchange;

    public OtpMessage(String exchange, String routingKey, String to, String otp) {
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.to = to;
        this.otp = otp;
    }

    public OtpMessage() {}
}
