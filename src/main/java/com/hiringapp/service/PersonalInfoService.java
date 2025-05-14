package com.hiringapp.service;

import com.hiringapp.model.entity.PersonalInfo;
import com.hiringapp.repository.PersonalInfoRepository;
import com.hiringapp.utils.dtos.PersonalInfoDTO;
import com.hiringapp.utils.mapper.PersonalInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalInfoService {
    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    @Autowired
    private PersonalInfoMapper personalInfoMapper;


    public PersonalInfoDTO savePersonalInfo(PersonalInfoDTO dto) {
        PersonalInfo entity = personalInfoMapper.toEntity(dto);
        PersonalInfo savedEntity = personalInfoRepository.save(entity);
        return personalInfoMapper.toDto(savedEntity);
    }

    public Optional<PersonalInfoDTO> getPersonalInfoById(Long id) {
        return personalInfoRepository.findById(id).map(personalInfoMapper::toDto);
    }

//    public List<PersonalInfo> getAllPersonalInfo(){
//        return personalInfoRepository.findAll();
//    }
//
//    public PersonalInfo getPersonalInfoById(Long id){
//        return personalInfoRepository.findById(id).orElse(null);
//    }
//
//    public PersonalInfo addDob(PersonalInfo personalInfo) throws Exception{
//        if(personalInfoRepository.existsById(personalInfo.getId())){
//            return personalInfoRepository.save(personalInfo);
//        }
//        else {
//            throw new Exception("Candidate does not exist");
//        }
//    }


}
