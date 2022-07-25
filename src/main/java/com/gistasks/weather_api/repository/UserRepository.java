package com.gistasks.weather_api.repository;

import com.gistasks.weather_api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String userName);
}