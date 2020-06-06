package com.sura.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MessageVO {

    private String version;
    private Map<String,Object> template;


}
