package com.hiringapp.service;

import com.hiringapp.exceptions.CandidateNotFoundException;
import com.hiringapp.exceptions.ResourceNotFoundException;
import com.hiringapp.model.entity.BankInfo;
import com.hiringapp.model.entity.Candidate;
import com.hiringapp.repository.BankInfoRepository;
import com.hiringapp.repository.CandidateRepository;
import com.hiringapp.utils.dtos.BankInfoDTO;
import com.hiringapp.utils.mapper.BankInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankInfoService {

    @Autowired
    private BankInfoRepository bankInfoRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private BankInfoMapper bankInfoMapper;

    public BankInfoDTO saveBankInfo(BankInfoDTO dto) {
        Candidate candidate = candidateRepository.findById((long) dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found"));

        BankInfo bank = bankInfoMapper.toEntity(dto);
        bank.setBankName(dto.getBankName());
        return bankInfoMapper.toDTO(bankInfoRepository.save(bank));
    }

    public BankInfoDTO getBankInfoById(Long id) {
        BankInfo info = bankInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank info not found"));
        return bankInfoMapper.toDTO(info);
    }
}
