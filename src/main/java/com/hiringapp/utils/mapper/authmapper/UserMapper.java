package com.hiringapp.utils.mapper.authmapper;

import com.hiringapp.model.authEntity.User;
import com.hiringapp.utils.authDto.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserMapperHelper.class)
public interface UserMapper {

    @Mapping(target = "password", source = "password", qualifiedByName = "encodePassword")
    User toUser(RegisterRequest registerRequest);
}
