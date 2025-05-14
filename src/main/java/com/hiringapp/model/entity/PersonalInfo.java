package com.hiringapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(name = "personal_info")
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToOne(mappedBy = )
//    private Candidate candidate;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
