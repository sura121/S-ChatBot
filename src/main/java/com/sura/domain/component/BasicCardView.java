package com.sura.domain.component;

import com.sura.domain.subtype.BasicCard;
import com.sura.domain.variable.Component;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class BasicCardView implements Component  {

    private BasicCard basicCard;
}
