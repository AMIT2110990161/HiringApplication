package com.hiringapp.utils.mapper;

import com.hiringapp.model.entity.BankInfo;
import com.hiringapp.utils.dtos.BankInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface BankInfoMapper {

    @Mapping(source = "candidateId", target = "candidate.id")
    BankInfo toEntity(BankInfoDTO dto);

    @Mapping(source = "candidate.id", target = "candidateId")
    BankInfoDTO toDTO(BankInfo entity);
}

//@Component
//public class BankInfoMapper {
//
//    public BankInfoDTO toDTO(BankInfo bankInfo) {
//        if(bankInfo == null){
//            return null;
//        }
//
//        BankInfoDTO bankInfoDTO = new BankInfoDTO();
//        bankInfoDTO.setBankName(bankInfo.getBankName());
//        bankInfoDTO.setAccountNumber(String.valueOf(bankInfo.getAccountNumber()));
//        bankInfoDTO.setIfscCode(bankInfo.getIfscCode());
//
//        return bankInfoDTO;
//    }
//
//    public BankInfo toEntity(BankInfoDTO bankInfoDTO) {
//        if(bankInfoDTO == null){
//            return null;
//        }
//
//        BankInfo bankInfo = new BankInfo();
//        bankInfo.setBankName(bankInfoDTO.getBankName());
//        bankInfo.setAccountNumber(bankInfoDTO.getAccountNumber());
//        bankInfo.setIfscCode(bankInfoDTO.getIfscCode());
//
//        return bankInfo;
//    }
//}
