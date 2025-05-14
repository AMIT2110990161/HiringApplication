package com.hiringapp.controller.consumer;

import com.hiringapp.service.OtpMessageService;
import com.hiringapp.utils.authDto.OtpMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OtpListener {
    private final OtpMessageService otpMessageService;

    public OtpListener(final OtpMessageService otpMessageService) {
        this.otpMessageService = otpMessageService;
    }

    @RabbitListener(queues = "hiringAuthOtpQueue")
    public void receive(final OtpMessage message) {
        if (message.routingKey().equals("auth.otp")){
            otpMessageService.sendOtpEmail(message);
        }
    }
}
