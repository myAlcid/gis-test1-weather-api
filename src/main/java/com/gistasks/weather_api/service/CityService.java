package com.gistasks.weather_api.service;

import com.gistasks.weather_api.dto.CityDto;
import com.gistasks.weather_api.entity.CityEntity;
import com.gistasks.weather_api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    public CityEntity saveCity (CityDto сityDto){
        CityEntity cityEntity = new CityEntity(сityDto);
       return repository.save(cityEntity);
    }

    public CityEntity getCityByName (String name){
        return repository.findByName(name);
    }


}
