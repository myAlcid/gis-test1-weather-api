package com.gistasks.weather_api.controller;


import com.gistasks.weather_api.dto.UserDto;
import com.gistasks.weather_api.entity.Role;
import com.gistasks.weather_api.entity.UserEntity;
import com.gistasks.weather_api.exeptions.UsernameExistException;
import com.gistasks.weather_api.service.UserService;
import com.gistasks.weather_api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser (@RequestBody @Valid UserDto userDto) throws UsernameExistException {
        userService.saveUser(userDto);
        String successfullyAddingUserMessage = "You successfully added user";
        return new ResponseEntity<>(successfullyAddingUserMessage,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String generateToken(@RequestBody @Valid UserDto userDto) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        return jwtUtil.generateToken(userDto.getUsername());
    }
}
