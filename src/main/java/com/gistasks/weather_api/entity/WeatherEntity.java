package com.gistasks.weather_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Weather")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherEntity {
    @Id
    @GeneratedValue
    private long id;
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private double windDegree;
    private long timestamp;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;
}
