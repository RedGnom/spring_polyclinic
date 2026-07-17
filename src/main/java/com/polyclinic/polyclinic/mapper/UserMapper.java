package com.polyclinic.polyclinic.mapper;

import com.polyclinic.polyclinic.dto.RegisterDto;
import com.polyclinic.polyclinic.dto.UserDto;
import com.polyclinic.polyclinic.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    User toUserEntity(RegisterDto registerDto);
}
