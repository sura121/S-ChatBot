package com.sura.global;

import com.sura.controller.SChatBotController;
import com.sura.resource.ApiKeys;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ApiCall {

    private final static Logger logger = LoggerFactory.getLogger(ApiCall.class);

    @Autowired
    private RestTemplate googleApiRes;

    private final static String G_END_POINT = "https://maps.googleapis.com/maps/api/geocode/json";

    public Map<String, String> apiCall(String city) {

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("11");
        encryptor.setAlgorithm("PBEwithMD5AndDES");


        String key = encryptor.decrypt(ApiKeys.googleApiKey);
        Map<String,String> queryString = new HashMap<>();

        queryString.put("key",key);
        queryString.put("address","서울");

        logger.info("key : "+key+ " encytrpt : "+ ApiKeys.googleApiKey);

        ResponseEntity<String> res = googleApiRes.getForEntity(G_END_POINT+"?address={address}&key={key}",String.class,queryString);

        String jsonString = res.getBody();

        JsonParse parser = new JsonParse();

        Map resObj = parser.parseResponse("results",jsonString);

        JSONObject lastObj =(JSONObject) resObj.get("geometry");

        HashMap<String,String> coordinate = (HashMap<String, String>) lastObj.get("location");


        return coordinate;

    }
}
