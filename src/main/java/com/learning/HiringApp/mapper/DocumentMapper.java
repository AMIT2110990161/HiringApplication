package com.learning.HiringApp.mapper;


import com.learning.HiringApp.entity.Document;
import com.learning.HiringApp.dtos.DocumentDTO;

public class DocumentMapper {

    public static DocumentDTO toDTO(Document document) {
        return DocumentDTO.builder()
                .id(document.getId())
                .documentType(document.getDocumentType())
                .fileName(document.getFileName())
                .uploadedDate(document.getUploadedDate() != null
                        ? document.getUploadedDate().toString() : null)
                .candidateId(document.getCandidate().getId())
                .build();
    }
}



