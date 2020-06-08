package com.sura.controller;

import com.sura.resource.ApiKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    private static final String GOOGLE_API_KEY = ApiKeys.googleApiKey;
    private static final String WEATHER_API_KEY = ApiKeys.weatherApiKey;

    private static final String GOOGLE_API_ENDPOINT = "https://maps.googleapis.com/maps/api/geocode/json";

}
