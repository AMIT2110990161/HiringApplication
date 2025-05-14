package com.hiringapp.utils.mapper;

import com.hiringapp.model.entity.EducationalInfo;
import com.hiringapp.utils.dtos.EducationalInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EducationalInfoMapper {

    @Mapping(source = "candidateId", target = "candidate.id")
    EducationalInfo toEntity(EducationalInfoDTO dto);

    @Mapping(source = "candidate.id", target = "candidateId")
    EducationalInfoDTO toDto(EducationalInfo entity);


}
