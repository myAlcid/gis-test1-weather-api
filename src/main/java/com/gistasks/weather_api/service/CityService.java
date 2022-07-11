package com.gistasks.weather_api.service;

import com.gistasks.weather_api.dto.CityDto;
import com.gistasks.weather_api.dto.CreateCityDto;
import com.gistasks.weather_api.entity.CityEntity;
import com.gistasks.weather_api.mapper.CityMapper;
import com.gistasks.weather_api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    public CityDto saveCity(CreateCityDto createCityDto) {
        CityEntity cityEntityToSave = CityMapper.INSTANCE.toCityEntity(createCityDto);
        CityEntity createdCityEntity = repository.save(cityEntityToSave);
        return CityMapper.INSTANCE.toCityDto(createdCityEntity);
    }

    public CityDto getCityByName(String name) {
        CityEntity cityEntity = repository.findByName(name);
        return CityMapper.INSTANCE.toCityDto(cityEntity);
    }

}
