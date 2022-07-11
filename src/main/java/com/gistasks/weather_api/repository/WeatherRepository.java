package com.gistasks.weather_api.repository;

import com.gistasks.weather_api.dto.WeatherDto;
import com.gistasks.weather_api.entity.CityEntity;
import com.gistasks.weather_api.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherEntity,Integer> {
    @Query("SELECT w FROM WeatherEntity w WHERE w.city = ?1 AND w.timestamp >=?2 AND w.timestamp <=?3 ORDER BY w.timestamp")
    List<WeatherEntity> getHistory(CityEntity city, long from, long to);

    WeatherEntity findFirstByCityOrderByTimestampDesc (CityEntity city);

}
