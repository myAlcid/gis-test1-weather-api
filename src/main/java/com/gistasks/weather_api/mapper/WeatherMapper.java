package com.gistasks.weather_api.mapper;

import com.gistasks.weather_api.dto.WeatherDto;
import com.gistasks.weather_api.entity.WeatherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeatherMapper {


    WeatherEntity toWeatherEntity(WeatherDto weatherDto);

    WeatherDto toWeatherDto(WeatherEntity weatherEntity);

    List<WeatherDto> toWeatherDtos(List<WeatherEntity> weatherEntities);
}
