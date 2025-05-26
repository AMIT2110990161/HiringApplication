package com.hiringapp.controller.consumer;

import com.hiringapp.config.RabbitMQMail;
import com.hiringapp.model.entity.Document;
import com.hiringapp.repository.CandidateRepository;
import com.hiringapp.repository.DocumentRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class DocumentConsumer {

    private final CandidateRepository candidateRepository;
    private final DocumentRepository documentRepository;

    public DocumentConsumer(CandidateRepository candidateRepository, DocumentRepository documentRepository) {
        this.candidateRepository = candidateRepository;
        this.documentRepository = documentRepository;
    }


    @RabbitListener(queues = RabbitMQMail.DOCUMENT_QUEUE)
    public void handleCandidateCreated(Long candidateId) {

        log.info("Received Candidate ID from RabbitMQ: {}", candidateId);

        candidateRepository.findById(candidateId).ifPresent(candidate -> {
            Document document = Document.builder()
                    .candidate(candidate)
                    .documentType("EMPTY")
                    .fileName(null)
                    .fileData(null)
                    .uploadedDate(LocalDate.now().toString())
                    .build();
            documentRepository.save(document);
        });

        log.info("Empty Document row created for Candidate ID: {}", candidateId);
    }
}