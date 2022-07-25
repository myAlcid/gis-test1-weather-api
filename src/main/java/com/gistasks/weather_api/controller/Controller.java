package com.gistasks.weather_api.controller;

import com.gistasks.weather_api.dto.CityDto;
import com.gistasks.weather_api.dto.CreateCityDto;
import com.gistasks.weather_api.dto.WeatherDto;
import com.gistasks.weather_api.exeptions.DataNotFoundException;
import com.gistasks.weather_api.service.CityService;
import com.gistasks.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class Controller {
    @Autowired
    private CityService service;
    @Autowired
    private WeatherService weatherService;

    @PostMapping("/cities")
    public CityDto addCity(@RequestBody @Valid CreateCityDto createCityDto) {
        return service.saveCity(createCityDto);
    }

    @GetMapping("/cities")
    public CityDto findCityByName(@RequestParam(value = "city") String name) throws DataNotFoundException {
        return service.getCityByName(name);
    }

    @GetMapping("weather/current")
    public WeatherDto getCurrentWeather(@RequestParam(value = "city") String city) throws DataNotFoundException {
        return weatherService.getCurrentByCityName(city);
    }

    @GetMapping("/weather/history")
    public List<WeatherDto> getWeatherHistory(@RequestParam(value = "city") String city,
                                              @RequestParam(value = "from") long from,
                                              @RequestParam(value = "to") long to) throws DataNotFoundException {
        return weatherService.getHistory(city, from, to);
    }

}
