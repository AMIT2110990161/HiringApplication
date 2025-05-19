package com.learning.HiringApp.producer;


import com.learning.HiringApp.security.authDto.forgotpassword.OtpMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OtpProducerService {
    private final RabbitTemplate rabbitTemplate;

    public OtpProducerService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageToListener(OtpMessage otpMessage) {
        rabbitTemplate.convertAndSend(otpMessage.getExchange(), otpMessage.getRoutingKey(), otpMessage);
    }
}