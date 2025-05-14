package com.hiringapp.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String email;
    private String phoneNumber;
    private String status;

    @PastOrPresent(message = "Sent time can not be in the future")
    private LocalDateTime sentAt;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @PrePersist
    public void prePersist() {
        this.sentAt = LocalDateTime.now();
    }
//
//    @JsonManagedReference
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "bankInfoId")
//    private BankInfo bankInfo;
}
