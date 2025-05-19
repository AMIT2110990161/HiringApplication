package com.learning.HiringApp.consumer;

import com.learning.HiringApp.security.authDto.forgotpassword.OtpMessage;
import com.learning.HiringApp.service.EmailService;
import com.learning.HiringApp.security.config.RabbitMQMail;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OtpMessageListener {
    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = RabbitMQMail.OTP_QUEUE)
    public void receiveOtpMessage(OtpMessage message) {
        emailService.sendOtpEmail(message.getTo(), message.getOtp());
    }
}
