package com.learning.HiringApp.repository;

import com.learning.HiringApp.entity.EducationalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationalInfoRepository extends JpaRepository<EducationalInfo, Long> {
}