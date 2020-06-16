package com.sura.domain.subtype;

import com.sura.domain.variable.Component;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Template {

    private List<Component> output;

    public Template() {
        this.output = new ArrayList<>();
    }

    public Template(List<Component> ou) {
        this.output = ou;
    }

    public void addOutput(Component ou) {
        this.output.add(ou);
    }



}
