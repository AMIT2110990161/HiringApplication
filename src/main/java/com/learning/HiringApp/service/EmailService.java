package com.learning.HiringApp.service;

import com.learning.HiringApp.entity.Candidate;
import com.learning.HiringApp.security.authDto.forgotpassword.OtpMessage;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import java.util.List;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;


    @Autowired
    private TemplateEngine templateEngine;

    public void sendMailWithTemplate(String to, String subject, Map<String, Object> model) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        // Set email details
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom("amit70kumar14@gmail.com"); // Replace with your Gmail address

        // Process Thymeleaf template
        Context context = new Context();
        context.setVariables(model);
        String htmlContent = templateEngine.process("Mail", context); // Assumes you have a Thymeleaf template named email-template.html

        helper.setText(htmlContent, true);

        // Send email
        mailSender.send(mimeMessage);
    }

    public void sendOtpEmail(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your OTP for Password Reset");
        message.setText("Your OTP is: " + otp);
        mailSender.send(message);
    }

    public void sendOfferEmails(List<Candidate> candidates) {
        for (Candidate c : candidates) {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(c.getEmail());
            msg.setSubject("Job Offer");
            msg.setText("Congratulations " + c.getFullName() + "! You have been offered the job.");
            mailSender.send(msg);
        }
    }

}