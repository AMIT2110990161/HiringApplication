package com.learning.HiringApp.mapper;

import com.learning.HiringApp.dtos.EducationalInfoDTO;
import com.learning.HiringApp.entity.EducationalInfo;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EducationalInfoMapper {

    @Mapping(source = "candidateId", target = "candidate.id")
    EducationalInfo toEntity(EducationalInfoDTO dto);

    @Mapping(source = "candidate.id", target = "candidateId")
    EducationalInfoDTO toDto(EducationalInfo entity);


}