package com.sura.domain.subtype;

import com.sura.domain.variable.Component;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Text implements Component {

    private String text;

    @Builder
    public Text(String text) {
        this.text = text;
    }
}
