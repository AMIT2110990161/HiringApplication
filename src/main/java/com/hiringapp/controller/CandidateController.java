package com.hiringapp.controller;

import com.hiringapp.model.entity.Candidate;
import com.hiringapp.service.CandidateService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@Slf4j
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/all")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
        Candidate candidate = candidateService.getCandidatesById(id);
        return ResponseEntity.ok(candidate);
    }

    @PostMapping("/add")
    public ResponseEntity<Candidate> createCandidate(@Valid @RequestBody Candidate candidate) throws Exception {
        Candidate savedCandidate = candidateService.addCandidate(candidate);
        log.info("Candidate created: {}", savedCandidate);
        return ResponseEntity.ok(savedCandidate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id, @Valid @RequestBody Candidate candidate) {
        Candidate updatedCandidate = candidateService.updateCandidate(id, candidate);
        return ResponseEntity.ok(updatedCandidate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) throws Exception {
        candidateService.deleteCandidate(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCandidateCount() {
        long count = candidateService.countCandidates();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/report")
    public ResponseEntity<Resource> downloadCandidateReport() {
        ResponseEntity<Resource> reportResponse = candidateService.generateCandidateReport();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=candidate_report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(reportResponse.getBody());
    }
}
