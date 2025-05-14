package com.hiringapp.utils.mapper;

import com.hiringapp.model.entity.PersonalInfo;
import com.hiringapp.utils.dtos.PersonalInfoDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PersonalInfoMapper {

    // Manual mapping from PersonalInfo entity to PersonalInfoDTO
    public PersonalInfoDTO toDto(PersonalInfo personalInfo) {
        if (personalInfo == null) {
            return null;
        }

        PersonalInfoDTO personalInfoDTO = new PersonalInfoDTO();
        personalInfoDTO.setId(personalInfo.getId());
        personalInfoDTO.setDob(String.valueOf(personalInfo.getDob()));
        personalInfoDTO.setGender(personalInfo.getGender());
        personalInfoDTO.setAddress(personalInfo.getAddress());

        return personalInfoDTO;
    }

    // Manual mapping from PersonalInfoDTO to PersonalInfo entity
    public PersonalInfo toEntity(PersonalInfoDTO personalInfoDTO) {
        if (personalInfoDTO == null) {
            return null;
        }

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setId(personalInfoDTO.getId());
        personalInfo.setDob(LocalDate.parse(personalInfoDTO.getDob()));
        personalInfo.setGender(personalInfoDTO.getGender());
        personalInfo.setAddress(personalInfoDTO.getAddress());

        return personalInfo;
    }
}


//package com.hiringapp.utils.mapper;
//
//import com.hiringapp.model.entity.PersonalInfo;
//import com.hiringapp.utils.dtos.PersonalInfoDTO;
//import org.mapstruct.Mapper;
//
//@Mapper(componentModel = "spring")
//public interface PersonalInfoMapper {
//    PersonalInfoDTO toDto(PersonalInfo personalInfo);
//    PersonalInfo toEntity(PersonalInfoDTO personalInfoDTO);
//}
