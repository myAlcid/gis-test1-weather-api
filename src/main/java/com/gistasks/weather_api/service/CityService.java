package com.gistasks.weather_api.service;

import com.gistasks.weather_api.dto.CityDto;
import com.gistasks.weather_api.dto.CreateCityDto;
import com.gistasks.weather_api.entity.CityEntity;
import com.gistasks.weather_api.exeptions.DataNotFoundException;
import com.gistasks.weather_api.mapper.CityMapper;
import com.gistasks.weather_api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityMapper cityMapper;

    public CityDto saveCity(CreateCityDto createCityDto) {
        CityEntity cityEntityToSave = cityMapper.toCityEntity(createCityDto);
        CityEntity createdCityEntity = cityRepository.save(cityEntityToSave);
        return cityMapper.toCityDto(createdCityEntity);
    }

    public CityDto getCityByName(String name) throws DataNotFoundException {
        CityEntity cityEntity = cityRepository.findByName(name);
        if (cityEntity == null) {
            throw new DataNotFoundException("city with name '" + name + "' not found!");
        } else
            return cityMapper.toCityDto(cityEntity);
    }
}
