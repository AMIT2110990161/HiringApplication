package com.hiringapp.repository;


import com.hiringapp.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Optional<Document> findFirstByCandidateIdAndFileDataIsNull(Long candidateId);

    boolean existsByCandidateId(Long candidateId);
}