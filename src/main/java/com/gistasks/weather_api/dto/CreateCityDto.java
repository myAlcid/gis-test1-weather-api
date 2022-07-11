package com.gistasks.weather_api.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class CreateCityDto {
    @NotNull
    @Size(min=2,max=20)
    private String name;
    @NotNull
    private double longitude;
    @NotNull
    private double latitude;

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
