package com.hiringapp.service;


import com.hiringapp.model.dtos.BankInfoDTO;
import com.hiringapp.model.entity.BankInfo;
import com.hiringapp.model.entity.Candidate;
import com.hiringapp.exceptions.ResourceNotFoundException;
import com.hiringapp.model.mapper.BankInfoMapper;
import com.hiringapp.repository.BankInfoRepository;
import com.hiringapp.repository.CandidateRepository;
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

