package com.hiringapp.repository;

import com.hiringapp.model.entity.EducationalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationalInfoRepository extends JpaRepository<EducationalInfo, Long> {
}