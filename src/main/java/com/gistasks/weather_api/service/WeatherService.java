package com.gistasks.weather_api.service;

import com.gistasks.weather_api.dto.WeatherDto;
import com.gistasks.weather_api.entity.CityEntity;
import com.gistasks.weather_api.entity.WeatherEntity;
import com.gistasks.weather_api.mapper.WeatherMapper;
import com.gistasks.weather_api.repository.CityRepository;
import com.gistasks.weather_api.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    private CityRepository cityRepository;

    public WeatherDto getCurrentByCityName(String cityName) {
        CityEntity cityEntity = cityRepository.findByName(cityName);
        WeatherEntity weatherEntity = weatherRepository.findFirstByCityOrderByTimestampDesc(cityEntity);
        return WeatherMapper.INSTANCE.toWeatherDto(weatherEntity);
    }

    public List<WeatherDto> getHistory(String city, long from, long to) {
        CityEntity cityEntity = cityRepository.findByName("Lviv");
        List<WeatherEntity> weatherEntities = weatherRepository.getHistory(cityEntity, from, to);
        return WeatherMapper.INSTANCE.toWeatherDtos(weatherEntities);
    }
}
