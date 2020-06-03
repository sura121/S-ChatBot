package com.sura.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "TB_BOARD")
public class BoardVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(length = 100, nullable = false)
    private String id;

}
