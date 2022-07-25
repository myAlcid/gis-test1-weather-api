package com.gistasks.weather_api;

import com.gistasks.weather_api.dto.UserDto;
import com.gistasks.weather_api.entity.Role;
import com.gistasks.weather_api.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run (UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER",null));

            userService.saveUser(new UserDto("alex","12345678"));
            userService.saveUser(new UserDto("root","rootroot"));
            userService.saveUser(new UserDto("john","abcdabcd"));
        };
    }

}
