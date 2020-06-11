package com.sura.global;

import com.sura.resource.ApiKeys;
import com.sura.resource.ConfigResource;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;


/**
 * return type domain 관리 필요
 */
@Service
public class ApiCall {

    private final static Logger logger = LoggerFactory.getLogger(ApiCall.class);

    @Autowired
    private RestTemplate googleApiRes;

    private final static String G_END_POINT = "https://maps.googleapis.com/maps/api/geocode/json";
    private final static String W_END_POINT = "https://api.openweathermap.org/data/2.5/weather";

    public JSONObject apiCall(String city) {

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("11");
        encryptor.setAlgorithm("PBEwithMD5AndDES");

        String apikey = encryptor.decrypt(ConfigResource.GOOGLE_API_KEY.getApiKey());

        Map<String,String> queryString = new HashMap<>();

        queryString.put("key",apikey);
        queryString.put("address",city);

        ResponseEntity<String> res = googleApiRes.getForEntity(G_END_POINT+"?address={address}&key={key}",String.class,queryString);

        String jsonString = res.getBody();

        JsonParse parser = new JsonParse();

        Map resObj = parser.parseResponse("results",jsonString);

        JSONObject lastObj =(JSONObject) resObj.get("geometry");

        JSONObject coordinate =(JSONObject) lastObj.get("location");

        return coordinate;

    }

    public HashMap<String,Map> temperatureApi(String lat, String lng) {

        logger.info("temp in ?? ");

        HashMap<String,Map> result = new HashMap<>();

        Map<String,String> queryString = new HashMap<>();

        queryString.put("key",ConfigResource.WEATHER_API_KEY.getApiKey());
        queryString.put("lon",lng);
        queryString.put("lat",lat);

        logger.info(queryString.toString());

        ResponseEntity<String> res = googleApiRes.getForEntity(W_END_POINT+"?lon={lon}&lat={lat}&appid={key}",String.class,queryString);
        logger.info(res.toString());
        String jsonString = res.getBody();

        JsonParse parser = new JsonParse();

        HashMap weather = parser.parseResponse("weather",jsonString);
        HashMap temp = parser.parseResponse("main",jsonString);

        result.put("weather", weather);
        result.put("temp", temp);

        return result;
    }

}
