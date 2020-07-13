package com.sura.domain.weatherinfo;

import com.sura.resource.Cities;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
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

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column
    @UpdateTimestamp
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
//
//    @PrePersist
//    protected void prePersist() {
//        if(this.created_at == null) {
//            created_at = new Date();
//        }
//    }

    private boolean citiNullCheck(String city) {

        if(Cities.findByCity(city) == null ){
            return  true;
        }

        return  false;
    }



}
