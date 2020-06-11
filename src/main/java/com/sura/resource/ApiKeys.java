package com.sura.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiKeys {

    public static String googleApiKey;
    public static String weatherApiKey;

    @Value("${custom.google.api-key}")
    public void setGoogleApiKey(String googleApiKey){
        this.googleApiKey = googleApiKey;
    }

    @Value("${custom.weather.api-key}")
    public void setWeatherApiKey(String weatherApiKey){
        this.weatherApiKey = weatherApiKey;
    }

}
