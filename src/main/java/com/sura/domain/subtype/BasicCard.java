package com.sura.domain.subtype;

import com.sura.domain.variable.Component;
import lombok.*;

import java.awt.*;
import java.util.HashMap;

@Data
@AllArgsConstructor
@Builder
public class BasicCard implements Component {

    private HashMap<String, Object> thumbnail;
    private String description;
    private String title;

}
