package com.gistasks.weather_api.service;

import com.gistasks.weather_api.dto.WeatherDto;
import com.gistasks.weather_api.entity.CityEntity;
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
        return weatherRepository.findFirstByCityOrderByTimestampDesc(cityEntity);
    }

    public List<WeatherDto> getHistory(String city, long from, long to) {
        CityEntity cityEntity = cityRepository.findByName("Lviv");
        List<WeatherDto> weatherEntities = weatherRepository.getHistory(cityEntity, from, to);
        return weatherEntities;
    }
}
