package com.hiringapp.controller;


import com.hiringapp.service.PersonalInfoService;
import com.hiringapp.utils.dtos.PersonalInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates/personal-info")
public class PersonalInfoController {
    @Autowired
    private PersonalInfoService personalInfoService;

    @PostMapping
    public ResponseEntity<PersonalInfoDTO> create(@RequestBody PersonalInfoDTO dto) {
        return ResponseEntity.ok(personalInfoService.savePersonalInfo(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalInfoDTO> getById(@PathVariable Long id) {
        return personalInfoService.getPersonalInfoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
