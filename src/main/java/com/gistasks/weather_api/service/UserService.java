package com.gistasks.weather_api.service;

import com.gistasks.weather_api.dto.UserDto;
import com.gistasks.weather_api.entity.Role;
import com.gistasks.weather_api.entity.UserEntity;
import com.gistasks.weather_api.exeptions.UsernameExistException;
import com.gistasks.weather_api.mapper.UserMapper;
import com.gistasks.weather_api.repository.RoleRepository;
import com.gistasks.weather_api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {
    private final String DEFAULT_ROLE = "ROLE_USER";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    public void saveUser(UserDto userDto) throws UsernameExistException {
        UserEntity newUser = userRepository.findByUsername(userDto.getUsername());
        if (newUser != null)
            throw new UsernameExistException("User with username: " + userDto.getUsername() + " already exist!");

        Role userRole = roleRepository.findByName(DEFAULT_ROLE);
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(userRole);

        UserEntity userEntityToSave = userMapper.toUserEntity(userDto);
        userEntityToSave.setPassword(passwordEncoder.encode(userEntityToSave.getPassword()));
        userEntityToSave.setRoles(userRoles);

        userRepository.save(userEntityToSave);
    }

    public void saveRole(Role role){
        roleRepository.save(role);
    }
}
