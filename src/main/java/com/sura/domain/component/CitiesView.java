package com.sura.domain.component;

import com.sura.domain.subtype.CityList;
import com.sura.domain.variable.Component;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CitiesView implements Component {

    private CityList citiesView;

}
