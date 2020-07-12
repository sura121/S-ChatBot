package com.sura.domain.weatherinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Table(name = "WEATHER")
@Entity
@Getter
@NoArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Timestamp created_at;

    @Column(nullable = false)
    private Timestamp updated_at;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Double temp;

    @Builder
    private Weather(String city, Date date, Double temp){
        this.city = city;
        this.date = date;
        this.temp = temp;
    }



}
