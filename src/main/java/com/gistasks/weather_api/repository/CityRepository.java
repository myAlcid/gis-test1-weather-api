package com.gistasks.weather_api.repository;

import com.gistasks.weather_api.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    CityEntity findByName(String name);
}
