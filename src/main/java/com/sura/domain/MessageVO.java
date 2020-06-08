package com.sura.domain;

import lombok.Data;


import java.util.Map;

@Data
public class MessageVO {

    private int code;
    private Map<String,Object> template;

    public MessageVO() {
        this.code = 200;
    }



}
