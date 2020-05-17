package com.sura.domain;

import lombok.Data;

@Data
public class MessageVO {

    private String message;
    private int id;
    private String name;
    private String desc;
    private int quantity;
    private int code;

}
