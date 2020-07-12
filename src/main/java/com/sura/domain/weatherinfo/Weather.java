package com.sura.domain.weatherinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "WEATHER")
@Entity
@Getter
@NoArgsConstructor
@ToString
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

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
