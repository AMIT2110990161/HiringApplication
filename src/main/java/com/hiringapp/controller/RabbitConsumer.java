package com.hiringapp.controller;

import com.hiringapp.config.RabbitMQMail;
import com.hiringapp.service.EmailService;
import com.hiringapp.utils.dtos.CandidateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class RabbitConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = RabbitMQMail.QUEUE_NAME)
    public void receiveCandidate(CandidateDTO candidateDTO) {
        log.info("📩 Received message from queue: {}", candidateDTO);

        String subject = "Candidate Status Update";

        Map<String, Object> model = new HashMap<>();
        model.put("name", candidateDTO.getFullName());

        // Ensure status is a lowercase string for Thymeleaf
        String normalizedStatus = String.valueOf(candidateDTO.getStatus()).trim().toLowerCase();
        model.put("status", normalizedStatus);

        log.info("📧 Sending email to: {}", candidateDTO.getEmail());
        emailService.sendMailWithTemplate(candidateDTO.getEmail(), subject, model);
        log.info("✅ Email sent successfully.");
    }
}

//package com.hiringapp.controller;
//
//
//import com.hiringapp.config.RabbitMQMail;
//import com.hiringapp.service.EmailService;
//import com.hiringapp.utils.dtos.CandidateDTO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//@Slf4j
//public class RabbitConsumer {
//
//    @Autowired
//    private EmailService emailService;
//
//    @RabbitListener(queues = RabbitMQMail.QUEUE_NAME)
//    public void receiveCandidate(CandidateDTO candidateDTO) {
//        log.info("📩 Received message from queue: {}", candidateDTO);
//
//        String subject = "Candidate Status Update";
//
//        Map<String, Object> model = new HashMap<>();
//        model.put("name", candidateDTO.getFullName());
//        model.put("status", candidateDTO.getStatus());
//
//        log.info("📧 Sending email to: {}", candidateDTO.getEmail());
//        emailService.sendMailWithTemplate(candidateDTO.getEmail(), subject, model);
//        log.info("✅ Email sent successfully.");
//    }
//}
