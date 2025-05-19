package com.learning.HiringApp.service;

import com.learning.HiringApp.entity.Candidate;
import com.learning.HiringApp.entity.EducationalInfo;
import com.learning.HiringApp.exceptions.ResourceNotFoundException;
import com.learning.HiringApp.repository.CandidateRepository;
import com.learning.HiringApp.repository.EducationalInfoRepository;
import com.learning.HiringApp.dtos.EducationalInfoDTO;
import com.learning.HiringApp.mapper.EducationalInfoMapper;
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
        Candidate candidate= candidateRepository.findById(dto.getCandidateId())
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
