package com.gistasks.weather_api.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gistasks.weather_api.dto.WeatherDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class WeatherApiClient {
    @Value("${weather.api.url}")
    private String baseUrl;
    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.units}")
    private String weatherUnits;

    public WeatherDto getCurrentWeather(double lat, double lon) {
        String latitude = String.valueOf(lat);
        String longitude = String.valueOf(lon);
        String url = String.format(baseUrl + "?lat=%s&lon=%s&appid=%s&units=%s", latitude, longitude, apiKey,weatherUnits);
        WeatherDto weatherDto = new WeatherDto();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonNode weatherNode = new ObjectMapper().readTree(response.body());
                weatherDto.setTemp(weatherNode.get("main").get("temp").asDouble());
                weatherDto.setFeelsLike(weatherNode.get("main").get("feels_like").asDouble());
                weatherDto.setTempMin(weatherNode.get("main").get("temp_min").asDouble());
                weatherDto.setTempMax(weatherNode.get("main").get("temp_max").asDouble());
                weatherDto.setPressure(weatherNode.get("main").get("pressure").asDouble());
                weatherDto.setHumidity(weatherNode.get("main").get("humidity").asDouble());
                weatherDto.setWindSpeed(weatherNode.get("wind").get("speed").asDouble());
                weatherDto.setWindDegree(weatherNode.get("wind").get("deg").asDouble());
                weatherDto.setTimestamp(weatherNode.get("dt").asLong());
            }
        } catch (JsonProcessingException | URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return weatherDto;
    }
}
