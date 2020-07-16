package com.sura.domain.subtype;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SimpleText {

    private String text;

    @Builder
    public SimpleText(String text) {
        this.text = text;
    }
}
