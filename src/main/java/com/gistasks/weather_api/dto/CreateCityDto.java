package com.gistasks.weather_api.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateCityDto {
    @NotNull(message = "city name should not be null")
    @Size(min=2,max=20, message = "size of city name should be between 2 and 20")
    private String name;
    @NotNull(message = "longitude name should not be null")
    @Min(value = -180)
    @Max(value = 180)
    private Double longitude;
    @NotNull
    @Min(value = -180)
    @Max(value = 180)
    private Double latitude;
}
