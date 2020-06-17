package com.sura.resource;

import org.omg.CORBA.UNKNOWN;

import javax.validation.constraints.Null;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public enum WeatherCondition {


    WEATHER_CONDITIONS(Arrays.asList("흐림","비","추움","더움"),Arrays.asList("CLOUD", "RAIN", "COLD", "HOT"));

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


        return  w;
    }
}
