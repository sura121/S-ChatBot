package com.sura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@org.springframework.boot.autoconfigure.SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},
scanBasePackages = {"com.sura.*"})
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
