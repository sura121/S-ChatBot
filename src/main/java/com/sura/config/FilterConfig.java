package com.sura.config;

import com.sura.filter.WeatherFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;


@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter( weatherDofilter());
        filterRegistrationBean.addUrlPatterns("/chat/*");


        return filterRegistrationBean;
    }

    @Bean(name = "weatherDofilter")
    public Filter weatherDofilter() {
        return new WeatherFilter();
    }


}
