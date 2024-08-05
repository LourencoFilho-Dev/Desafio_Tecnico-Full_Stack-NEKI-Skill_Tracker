package com.example.skilltracker.mapper;

import com.example.skilltracker.dtos.UserDto;
import com.example.skilltracker.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    void updateEntityFromDto(UserDto userDto, @MappingTarget User user);
}


