package com.sura.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class TemperatureVO {

    private String temp_min;
    private String temp;
    private String humidity;
    private String pressure;
    private String feel_like;
    private String temp_max;

}
