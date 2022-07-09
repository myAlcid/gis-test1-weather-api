package com.gistasks.weather_api.entity;

import com.gistasks.weather_api.dto.CityDto;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double longitude;
    private double latitude;

    public CityEntity(CityDto createCityDto){
        this.name = createCityDto.getName();
        this.longitude = createCityDto.getLongitude();
        this.latitude = createCityDto.getLatitude();
    }

    public CityEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
