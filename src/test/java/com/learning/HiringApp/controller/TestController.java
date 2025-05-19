package com.learning.HiringApp.controller;

import com.learning.HiringApp.producer.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RabbitProducer rabbitProducer;

//    @PostMapping("/send")
//    public ResponseEntity<String> sendTestCandidate() {
//        System.out.println("Endpoint /api/test/send called");
//        CandidateDTO testCandidate = new CandidateDTO();
//        testCandidate.setFullName("Simran Dhiman");
//        testCandidate.setEmail("simrandhiman3121@gmail.com");
//        testCandidate.setStatus("offered");
//        rabbitProducer.sendCandidate(testCandidate);
//        return ResponseEntity.ok("Message sent");
//    }

    @PostMapping("/send")
    public ResponseEntity<String> sendTestCandidate() {
        return ResponseEntity.ok("Message sent");
    }



}

