package com.gistasks.weather_api.dto;



import javax.validation.constraints.*;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
