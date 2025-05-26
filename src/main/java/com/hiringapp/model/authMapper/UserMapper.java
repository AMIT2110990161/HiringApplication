package com.hiringapp.model.authMapper;

import com.hiringapp.model.authDto.RegisterRequest;
import com.hiringapp.model.authEntity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserMapperHelper.class)
public interface UserMapper {

    @Mapping(target = "password", source = "password", qualifiedByName = "encodePassword")
    User toUser(RegisterRequest registerRequest);
}