package com.gistasks.weather_api.dto;

import lombok.Data;

@Data
public class WeatherDto {
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private double windDegree;
    private long timestamp;
}
