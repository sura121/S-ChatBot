package com.sura.resource;

public enum ConfigResource {

    GOOGLE_API_KEY("",ApiKeys.googleApiKey),
    WEATHER_API_KEY("",ApiKeys.weatherApiKey);

    private String city;
    private String apiKey;


    ConfigResource(String city, String apiKey) {
        this.city = city;
        this.apiKey = apiKey;
    }

    public String getApiKey(){
        return apiKey;
    }


}
