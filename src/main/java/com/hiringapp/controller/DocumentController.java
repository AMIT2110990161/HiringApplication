package com.hiringapp.controller;


import com.hiringapp.model.entity.Document;
import com.hiringapp.repository.DocumentRepository;
import com.hiringapp.service.DocumentService;
import com.hiringapp.utils.dtos.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DocumentRepository documentRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadMultipleDocuments(
            @RequestParam("documentType") String documentType,
            @RequestParam("candidateId") Long candidateId,
            @RequestParam("files") List<MultipartFile> files
    ) {
        try {
            List<DocumentDTO> documents = documentService.uploadMultipleDocuments(documentType, candidateId, files);
            return ResponseEntity.ok(documents);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long id) {
        return documentService.downloadDocument(id);
    }


    @GetMapping("/check/{candidateId}")
    public ResponseEntity<Boolean> checkDocument(@PathVariable Long candidateId) {
        return new ResponseEntity<>(documentService.checkIfAnyDocumentExists(candidateId), HttpStatus.OK);
    }

}
