package com.sura.global;

import com.sura.resource.ApiKeys;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final RestTemplateBuilder restTemplateBuilder;

    private static final String GOOGLE_API_KEY = ApiKeys.googleApiKey;
    private static final String WEATHER_API_KEY = ApiKeys.weatherApiKey;

    private static final String GOOGLE_API_ENDPOINT = "https://maps.googleapis.com/maps/api/geocode/json";

    @Bean
    public RestTemplate GoogleApiRes() {

        return restTemplateBuilder.rootUri(GOOGLE_API_ENDPOINT)
                .additionalInterceptors(new RestTemplateClientHttpRequestInterceptor())
                .errorHandler(new RestTemplateErrorHandler())
                .setConnectTimeout(Duration.ofMinutes(3))
                .build();

    }

}
