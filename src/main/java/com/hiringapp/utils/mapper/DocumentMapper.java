package com.hiringapp.utils.mapper;

import com.hiringapp.model.entity.Document;
import com.hiringapp.utils.dtos.DocumentDTO;

public class DocumentMapper {

    public static DocumentDTO toDTO(Document document) {
        return DocumentDTO.builder()
                .id(document.getId())
                .documentType(document.getDocumentType())
                .fileName(document.getFileName())
                .uploadedDate(document.getUploadedDate())
                .candidateId((long) document.getCandidate().getId())
                .build();
    }
}
