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

    private List<Component> outputs;

    public Template() {
        this.outputs = new ArrayList<>();
    }

    public Template(List<Component> ou) {
        this.outputs = ou;
    }

    public void addOutput(Component ou) {
        this.outputs.add(ou);
    }



}
