package com.gistasks.weather_api.dto;

import lombok.Data;

@Data
public class CityDto {
    private long id;
    private String name;
    private double longitude;
    private double latitude;
}
