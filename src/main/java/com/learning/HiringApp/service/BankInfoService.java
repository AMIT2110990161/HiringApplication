package com.learning.HiringApp.service;


import com.learning.HiringApp.dtos.BankInfoDTO;
import com.learning.HiringApp.entity.BankInfo;
import com.learning.HiringApp.entity.Candidate;
import com.learning.HiringApp.exceptions.ResourceNotFoundException;
import com.learning.HiringApp.mapper.BankInfoMapper;
import com.learning.HiringApp.repository.BankInfoRepository;
import com.learning.HiringApp.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class BankInfoService {

    private final BankInfoRepository bankInfoRepository;
    private final CandidateRepository candidateRepository;
    private final BankInfoMapper bankInfoMapper;

    public BankInfoService(BankInfoRepository bankInfoRepository,
                           CandidateRepository candidateRepository,
                           BankInfoMapper bankInfoMapper) {
        this.bankInfoRepository = bankInfoRepository;
        this.candidateRepository = candidateRepository;
        this.bankInfoMapper = bankInfoMapper;
    }

    public BankInfoDTO saveBankInfo(BankInfoDTO dto) {
        Candidate candidate = candidateRepository.findById(dto.getCandidateId())
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found"));

        BankInfo bankInfo = bankInfoMapper.toEntity(dto);
        bankInfo.setCandidate(candidate);
        return bankInfoMapper.toDTO(bankInfoRepository.save(bankInfo));
    }

    public BankInfoDTO getBankInfoById(Long id) {
        BankInfo info = bankInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank info not found"));
        return bankInfoMapper.toDTO(info);
    }
}

