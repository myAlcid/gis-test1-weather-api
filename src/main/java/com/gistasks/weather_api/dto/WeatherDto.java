package com.gistasks.weather_api.dto;

import com.gistasks.weather_api.entity.WeatherEntity;

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

    public WeatherDto() {
    }

    public WeatherDto(WeatherEntity weatherEntity) {
        this.temp = weatherEntity.getTemp();
        this.feelsLike = weatherEntity.getFeelsLike();
        this.tempMin = weatherEntity.getTempMin();
        this.tempMax = weatherEntity.getTempMax();
        this.pressure = weatherEntity.getPressure();
        this.humidity = weatherEntity.getHumidity();
        this.windSpeed = weatherEntity.getWindSpeed();
        this.windDegree = weatherEntity.getWindDegree();
        this.timestamp = weatherEntity.getTimestamp();
    }

    public double getTemp() {
        return temp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(double windDegree) {
        this.windDegree = windDegree;
    }
}
