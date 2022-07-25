package com.gistasks.weather_api.mapper;

import com.gistasks.weather_api.dto.UserDto;
import com.gistasks.weather_api.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toUserEntity(UserDto userDto);

    UserDto toUserDto(UserEntity userEntity);
}
