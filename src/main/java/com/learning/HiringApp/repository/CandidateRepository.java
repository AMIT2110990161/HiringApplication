package com.learning.HiringApp.repository;

import com.learning.HiringApp.entity.Candidate;
import com.learning.HiringApp.enums.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT DISTINCT c FROM Candidate c ORDER BY c.fullName ASC")
    List<Candidate> findAllCandidates();
    List<Candidate> findByStatus(CandidateStatus status);
}
