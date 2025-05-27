package com.hiringapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
@Slf4j
public class CandidateOnboardingSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(CandidateOnboardingSystemApplication.class, args);
        log.info("Candidate Onboarding System Application Started");
    }

}
