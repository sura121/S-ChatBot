package com.sura.resource;

import org.junit.Test;

import java.util.Arrays;

public class WeatherConditionTest {

    @Test
    public void getKeyIndex() throws Exception{

        WeatherCondition weather = WeatherCondition.WEATHER_CONDITIONS;
       String s=  weather.getKeyIndex("튼구름");



    }

}