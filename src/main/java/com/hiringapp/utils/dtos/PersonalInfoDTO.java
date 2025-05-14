package com.hiringapp.utils.dtos;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "DOB is required")
    private String dob;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(?i)(male|female|other|prefer not to say)$")
    private String gender;

    @NotBlank(message = "Address is required")
    private String address;
}
