package com.sura.domain.subtype;

import com.sura.domain.variable.Component;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CityList implements Component {

    private String cityName;
}
