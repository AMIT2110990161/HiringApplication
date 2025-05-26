package com.hiringapp.model.mapper;


import com.hiringapp.model.dtos.BankInfoDTO;
import com.hiringapp.model.entity.BankInfo;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BankInfoMapper {

    @Mapping(source = "candidateId", target = "candidate.id")
    BankInfo toEntity(BankInfoDTO dto);

    @Mapping(source = "candidate.id", target = "candidateId")
    BankInfoDTO toDTO(BankInfo entity);
}
