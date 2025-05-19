package com.learning.HiringApp.service;

import com.learning.HiringApp.entity.Candidate;
import com.learning.HiringApp.enums.CandidateStatus;
import com.learning.HiringApp.exceptions.NotFoundException;
import com.learning.HiringApp.mapper.CandidateMapper;
import com.learning.HiringApp.producer.DocumentProducer;
import com.learning.HiringApp.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private DocumentProducer documentProducer;

    @Autowired
    private CandidateMapper candidateMapper;

    // ─────────────────────────────────────────────────────────────────────────────
    // GET ALL
    // ─────────────────────────────────────────────────────────────────────────────
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAllCandidates();
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // FIND BY ID
    // ─────────────────────────────────────────────────────────────────────────────
    public Candidate findById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Candidate not found"));
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // ADD NEW CANDIDATE
    // ─────────────────────────────────────────────────────────────────────────────
    @CachePut(value = "candidates", key = "#result.id")
    public Candidate addCandidate(Candidate candidate) throws Exception {
        if (candidateRepository.existsById(candidate.getId())) {
            throw new Exception("Candidate already exists");
        }

        // default status
        if (candidate.getStatus() == null) {
            candidate.setStatus(CandidateStatus.APPLIED);
        }

        Candidate saved = candidateRepository.save(candidate);
        log.info("Candidate saved with ID: {}", saved.getId());

        // create an empty Document row via RabbitMQ (DocumentProducer)
        documentProducer.sendCandidateId(saved.getId());
        return saved;
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // COUNT
    // ─────────────────────────────────────────────────────────────────────────────
    public long countCandidates() {
        return candidateRepository.count();
    }

    // ─────────────────────────────────────────────────────────────────────────────
    // FILTER BY STATUS
    // ─────────────────────────────────────────────────────────────────────────────
    public List<Candidate> getCandidatesByStatus(String status) {
        try {
            return candidateRepository.findByStatus(CandidateStatus.valueOf(status.toUpperCase()));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }
}