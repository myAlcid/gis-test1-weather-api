package com.gistasks.weather_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotBlank(message = "login should not be null or blank")
    @Size(min = 2, max = 20, message = "size of login should be between 2 and 20")
    private String username;
    @NotBlank(message = "password should not be null or blank")
    @Size(min = 8, message = "size of password should have minimum 8 characters")
    private String password;
}
