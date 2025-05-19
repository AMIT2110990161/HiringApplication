package com.learning.HiringApp.repository;

import com.learning.HiringApp.security.authEntity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, String> {
    Optional<Otp> findByEmailAndOtp(String email, String otp);
}
