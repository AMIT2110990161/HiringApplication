package com.hiringapp.model.dtos;
import lombok.*;


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
