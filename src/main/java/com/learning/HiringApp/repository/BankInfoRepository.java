package com.learning.HiringApp.repository;



import com.learning.HiringApp.entity.BankInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankInfoRepository extends JpaRepository<BankInfo, Long> {
}