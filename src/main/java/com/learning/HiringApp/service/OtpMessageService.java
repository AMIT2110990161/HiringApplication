package com.learning.HiringApp.service;

import com.learning.HiringApp.security.authDto.forgotpassword.OtpMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpMessageService {
    @Autowired
    private EmailService emailService;

    public void processOtpMessage(OtpMessage message) {
        emailService.sendOtpEmail(message.getTo(), message.getOtp());
    }
}