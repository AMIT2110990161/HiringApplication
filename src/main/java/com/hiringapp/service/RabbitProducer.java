package com.hiringapp.service;

import com.hiringapp.config.RabbitMQMail;
import com.hiringapp.model.entity.Candidate;
import com.hiringapp.utils.dtos.CandidateDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendCandidate(CandidateDTO candidateDTO) {
        if ("offered".equalsIgnoreCase(String.valueOf(candidateDTO.getStatus())) ||
                "rejected".equalsIgnoreCase(String.valueOf(candidateDTO.getStatus()))) {
            rabbitTemplate.convertAndSend(
                    RabbitMQMail.EXCHANGE,
                    RabbitMQMail.ROUTING_KEY,
                    candidateDTO
            );
        }
    }
}