package com.sura.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@ToString
public class ResponseVO {

    private Object template;
    private String version;


    public ResponseVO(String version) {
        this.template = new HashMap<>();
        this.version = "2.0";

    }

    public void setTemplate(Object value) {
        this.template = value;
    }


}
