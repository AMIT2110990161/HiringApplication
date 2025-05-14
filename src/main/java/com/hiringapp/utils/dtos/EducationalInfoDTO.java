package com.hiringapp.utils.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EducationalInfoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Degree name can not be empty")
    private String degreeName;

    @NotBlank(message = "Institution name can not be empty")
    private String institutionName;

    @NotBlank(message = "Year of passing can not be empty")
    @Pattern(regexp = "^(19[5-9][0-9]|20[0-9][0-9])$")
    private int yearOfPassing;
}


