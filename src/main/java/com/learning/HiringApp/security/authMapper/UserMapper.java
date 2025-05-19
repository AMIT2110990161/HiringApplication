package com.learning.HiringApp.security.authMapper;

import com.learning.HiringApp.security.authDto.registerrequest.RegisterRequest;
import com.learning.HiringApp.security.authEntity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", source = "password") // No encoding here
    User toUser(RegisterRequest registerRequest);
}