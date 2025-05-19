package com.learning.HiringApp.dtos;

import com.learning.HiringApp.entity.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO implements Serializable {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String status;

    private LocalDateTime sentAt;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    // Convert Candidate entity to CandidateDTO
    public static CandidateDTO fromEntity(Candidate candidate) {
        CandidateDTO dto = new CandidateDTO();
        dto.setId(candidate.getId()); // Convert Long to String if needed
        dto.setFullName(candidate.getFullName());
        dto.setEmail(candidate.getEmail());
        dto.setPhone(candidate.getPhoneNumber());
        dto.setStatus(candidate.getStatus() != null ? candidate.getStatus().name() : null);
        dto.setSentAt(LocalDateTime.now());
        dto.setCreatedDate(candidate.getCreatedDate());
        dto.setLastModifiedDate(candidate.getLastModifiedDate());
        return dto;
    }
}