package com.gistasks.weather_api.service;

import com.gistasks.weather_api.dto.WeatherDto;
import com.gistasks.weather_api.entity.CityEntity;
import com.gistasks.weather_api.entity.WeatherEntity;
import com.gistasks.weather_api.exeptions.DataNotFoundException;
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

    public WeatherDto getCurrentByCityName(String cityName) throws DataNotFoundException {
        CityEntity cityEntity = cityRepository.findByName(cityName);
        if (cityEntity == null) {
            throw new DataNotFoundException("city '" + cityName + "' not found!");
        }

        WeatherEntity weatherEntity = weatherRepository.findFirstByCityOrderByTimestampDesc(cityEntity);
        if (weatherEntity == null) {
            throw new DataNotFoundException("weather by city name '" + cityName + "'' not found");
        } else {
            return WeatherMapper.INSTANCE.toWeatherDto(weatherEntity);
        }
    }

    public List<WeatherDto> getHistory(String cityName, long from, long to) throws DataNotFoundException {
        CityEntity cityEntity = cityRepository.findByName(cityName);
        if (cityEntity == null) {
            throw new DataNotFoundException("city '" + cityName + "'' not found!");
        }
        List<WeatherEntity> weatherEntities = weatherRepository.getHistory(cityEntity, from, to);
        if (weatherEntities.size() == 0) {
            throw new DataNotFoundException("weather by city name '" + cityName + "' not found");
        }
        return WeatherMapper.INSTANCE.toWeatherDtos(weatherEntities);
    }
}
