package com.learning.HiringApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSmokeTest implements CommandLineRunner {
    private final JavaMailSender mailSender;

    public MailSmokeTest(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleMailMessage m = new SimpleMailMessage();
        m.setTo("amit70kumar14@gmail.com");      // YOUR email
        m.setSubject("SMTP smoke test");
        m.setText("If you see this, SMTP config is correct.");
        mailSender.send(m);
        System.out.println("🔥 MailSmokeTest: sent test message");
    }
}
