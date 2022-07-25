package com.gistasks.weather_api.mapper;

import com.gistasks.weather_api.dto.CityDto;
import com.gistasks.weather_api.dto.CreateCityDto;
import com.gistasks.weather_api.entity.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityEntity toCityEntity(CreateCityDto createCityDto);

    CityDto toCityDto(CityEntity cityEntity);
}
