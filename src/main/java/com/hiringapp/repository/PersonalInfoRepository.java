package com.hiringapp.repository;

import com.hiringapp.model.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
}
