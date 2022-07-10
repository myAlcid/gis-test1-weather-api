package com.gistasks.weather_api.component;

import com.gistasks.weather_api.dto.WeatherDto;
import com.gistasks.weather_api.entity.CityEntity;
import com.gistasks.weather_api.entity.WeatherEntity;
import com.gistasks.weather_api.repository.CityRepository;
import com.gistasks.weather_api.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleWeatherDataSaver {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private WeatherApiClient weatherApiClient;
    @Autowired
    private WeatherRepository weatherRepository;

    @Scheduled(cron = "0 */2 * * *")
    public void scheduleWeatherSave() {
        List<CityEntity> cityEntities = cityRepository.findAll();
        for (CityEntity city : cityEntities) {
            WeatherDto weatherDto = weatherApiClient.getCurrentWeather(city.getLatitude(), city.getLongitude());
            WeatherEntity weatherEntity = new WeatherEntity(weatherDto);
            weatherEntity.setCity(city);
            weatherRepository.save(weatherEntity);
        }
    }
}
