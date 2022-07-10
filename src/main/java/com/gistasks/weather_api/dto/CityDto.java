package com.gistasks.weather_api.dto;

import com.gistasks.weather_api.entity.CityEntity;
import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class CityDto {
    @NotNull
    @Size(min=2,max=20)
    private String name;
    @NotNull
    private double longitude;
    @NotNull
    private double latitude;

    public CityDto(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public CityDto(CityEntity cityEntity) {
        this.name = cityEntity.getName();
        this.longitude = cityEntity.getLongitude();
        this.latitude = cityEntity.getLatitude();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
