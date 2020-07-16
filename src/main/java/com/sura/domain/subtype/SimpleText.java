package com.sura.domain.subtype;

import com.sura.domain.variable.Component;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SimpleText implements Component {

    private String text;

    @Builder
    public SimpleText(String text) {
        this.text = text;
    }
}
