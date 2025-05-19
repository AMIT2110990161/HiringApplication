package com.learning.HiringApp.controller;

import com.learning.HiringApp.service.EducationalInfoService;
import com.learning.HiringApp.dtos.EducationalInfoDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/educational-info")
public class EducationalInfoController {

    private final EducationalInfoService educationalInfoService;

    public EducationalInfoController(EducationalInfoService educationalInfoService) {
        this.educationalInfoService = educationalInfoService;
    }

    @PostMapping
    public ResponseEntity<EducationalInfoDTO> createEducationalInfo(@Valid @RequestBody EducationalInfoDTO dto) {
        EducationalInfoDTO saved = educationalInfoService.saveEducationalInfo(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationalInfoDTO> getEducationalInfoById(@PathVariable Long id) {
        EducationalInfoDTO info = educationalInfoService.getById(id);
        return ResponseEntity.ok(info);
    }
}
