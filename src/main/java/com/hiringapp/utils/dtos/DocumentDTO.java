package com.hiringapp.utils.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDTO {
    private Long id;
    private String documentType;
    private String fileName;
    private String uploadedDate;
    private Long candidateId;
}

