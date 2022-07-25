package com.gistasks.weather_api.mapper;

import com.gistasks.weather_api.dto.UserDto;
import com.gistasks.weather_api.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    UserEntity toUserEntity(UserDto userDto);

    UserDto toUserDto(UserEntity userEntity);
}
