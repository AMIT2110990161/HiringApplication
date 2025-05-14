package com.hiringapp.service;

import com.hiringapp.exceptions.ResourceNotFoundException;
import com.hiringapp.model.entity.Candidate;
import com.hiringapp.model.entity.EducationalInfo;
import com.hiringapp.repository.CandidateRepository;
import com.hiringapp.repository.EducationalInfoRepository;
import com.hiringapp.utils.dtos.EducationalInfoDTO;
import com.hiringapp.utils.mapper.EducationalInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class EducationalInfoService {

    private final EducationalInfoRepository repository;
    private final CandidateRepository candidateRepository;
    private final EducationalInfoMapper mapper;

    public EducationalInfoService(
            EducationalInfoRepository repository,
            CandidateRepository candidateRepository,
            EducationalInfoMapper mapper) {
        this.repository = repository;
        this.candidateRepository = candidateRepository;
        this.mapper = mapper;
    }

    public EducationalInfoDTO saveEducationalInfo(EducationalInfo entity) {
        Candidate candidate = candidateRepository.findById(entity.getCandidate())
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found"));

        entity.setCandidate(candidate); // associate the candidate with the education info
        EducationalInfo savedEntity = repository.save(entity); // save the entity
        return mapper.toDto(savedEntity); // convert back to DTO and return
    }


    public EducationalInfoDTO getById(Long id) {
        EducationalInfo info = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Educational info not found"));

        return mapper.toDto(info);
    }
}
