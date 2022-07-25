package com.gistasks.weather_api.exeptions;

public class UsernameExistException extends Exception{

    public UsernameExistException(String message) {
        super(message);
    }
}
