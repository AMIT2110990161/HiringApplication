package com.learning.HiringApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Slf4j
@SpringBootApplication
@EntityScan(basePackages = {
		"com.learning.HiringApp.model",
		"com.learning.HiringApp.security",   // User, Otp, etc.
		"com.learning.HiringApp.entity"       // Candidate, BankInfo, Document, …
})
public class HiringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiringAppApplication.class, args);
		log.info("Server is running");
	}
}
