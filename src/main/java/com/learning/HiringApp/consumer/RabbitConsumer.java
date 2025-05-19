//package com.learning.HiringApp.consumer;
//
//import com.learning.HiringApp.security.config.RabbitMQMail;
//import com.learning.HiringApp.service.EmailService;
//import com.learning.HiringApp.dtos.CandidateDTO;
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
//        log.info("Received message from queue: {}", candidateDTO);
//
//        try {
//            String subject = "Candidate Status Update";
//
//            Map<String, Object> model = new HashMap<>();
//            model.put("name", candidateDTO.getFullName());
//            model.put("status", candidateDTO.getStatus());
//
//            log.info("Sending email to: {}", candidateDTO.getEmail());
//            emailService.sendMailWithTemplate(candidateDTO.getEmail(), subject, model);
//            log.info("Email sent successfully.");
//        } catch (Exception e) {
//            log.error("Failed to process CandidateDTO: {} ",candidateDTO,e);
//        }
//    }
//}
