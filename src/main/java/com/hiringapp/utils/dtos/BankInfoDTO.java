package com.hiringapp.utils.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankInfoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotBlank(message = "Bank name is required")
    private String bankName;

    @NotBlank(message = "Ifsc code is required")
    private String ifscCode;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

}
