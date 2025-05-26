package com.hiringapp.model.mapper;

import com.hiringapp.model.dtos.EducationalInfoDTO;
import com.hiringapp.model.entity.EducationalInfo;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EducationalInfoMapper {

    @Mapping(source = "candidateId", target = "candidate.id")
    EducationalInfo toEntity(EducationalInfoDTO dto);

    @Mapping(source = "candidate.id", target = "candidateId")
    EducationalInfoDTO toDto(EducationalInfo entity);


}