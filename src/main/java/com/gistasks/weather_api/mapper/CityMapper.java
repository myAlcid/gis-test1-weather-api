package com.gistasks.weather_api.mapper;

import com.gistasks.weather_api.dto.CityDto;
import com.gistasks.weather_api.dto.CreateCityDto;
import com.gistasks.weather_api.entity.CityEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityEntity toCityEntity(CreateCityDto createCityDto);

    CityDto toCityDto(CityEntity cityEntity);
}
