package com.sura.domain.component;

import com.sura.domain.subtype.SimpleText;
import com.sura.domain.variable.Component;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SimpleTextView implements Component {

    private SimpleText simpleText;

    @Builder
    public SimpleTextView(SimpleText simpleText) {
        this.simpleText = simpleText;
    }
}
