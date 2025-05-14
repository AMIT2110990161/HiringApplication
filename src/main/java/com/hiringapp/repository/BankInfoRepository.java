package com.hiringapp.repository;

import com.hiringapp.model.entity.BankInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankInfoRepository extends JpaRepository<BankInfo, Long> {
}
