package com.hiringapp.service;

import com.hiringapp.model.entity.Candidate;
import com.hiringapp.model.entity.EducationalInfo;
import com.hiringapp.exceptions.ResourceNotFoundException;
import com.hiringapp.repository.CandidateRepository;
import com.hiringapp.repository.EducationalInfoRepository;
import com.hiringapp.model.dtos.EducationalInfoDTO;
import com.hiringapp.model.mapper.EducationalInfoMapper;
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

    public EducationalInfoDTO saveEducationalInfo(EducationalInfoDTO dto) {
        Candidate candidate = candidateRepository.findById(dto.getCandidateId())
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found"));

        EducationalInfo entity = mapper.toEntity(dto);
        entity.setCandidate(candidate);

        return mapper.toDto(repository.save(entity));
    }

    public EducationalInfoDTO getById(Long id) {
        EducationalInfo info = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Educational info not found"));

        return mapper.toDto(info);
    }
}
