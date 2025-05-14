package com.hiringapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String degreeName;

    @Column(nullable = false, length = 50)
    private String institutionName;

    @Column(nullable = false, length = 50)
    private int yearOfPassing;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
