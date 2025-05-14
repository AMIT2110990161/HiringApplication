package com.hiringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class HiringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiringAppApplication.class, args);
	}

}
