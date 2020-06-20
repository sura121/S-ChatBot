package com.sura.resource;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public enum WeatherCondition {


    WEATHER_CONDITIONS(Arrays.asList("구름","비","추움","맑음","흐림"),Arrays.asList("CLOUD", "RAIN", "COLD", "HOT","CLOUD"));

    private List<String> weatherInfo;
    private List<String> weatherKey;


    WeatherCondition(List<String> weatherList, List<String> weatherKey) {
        this.weatherInfo = weatherList;
        this.weatherKey = weatherKey;
    }

    public List<String> getWeatherInfo() {
        return weatherInfo;
    }

    public List<String> getWeatherKey() {
        return weatherKey;
    }

    public String getKeyIndex(String weather) {

        OptionalInt idx = IntStream.range(0, weatherInfo.size())
                .filter(i -> weather.contains(weatherInfo.get(i)))
                .findFirst();

        String w = weatherKey.get(idx.getAsInt());
        System.out.println("asdasdasd"+ w);

        return  w;
    }
}
