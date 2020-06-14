package com.sura.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.domain.TemperatureVO;
import com.sura.global.ApiCall;
import com.sura.global.CalcTemp;
import com.sura.global.JsonParse;
import com.sura.resource.ConfigResource;
import com.sura.service.MessageService;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/chat")
public class SChatBotController {

    private final static Logger logger = LoggerFactory.getLogger(SChatBotController.class);

    @Autowired
    private ApiCall apiCall;

    @Autowired
    private RestTemplate googleApiRes;

    @Autowired
    private CalcTemp calcTemp;

    private final static String G_END_POINT = "https://maps.googleapis.com/maps/api/geocode/json";

    @RequestMapping(value = "/kkoChat/v1" , method= {RequestMethod.POST , RequestMethod.GET },headers = {"Accept=application/json"})
    public HashMap<String,Object> WeatherBot(@RequestBody Map<String,Object> params, HttpServletRequest request , HttpServletResponse response) {

        HashMap<String, Object> resultJson = new HashMap<>();

        try{

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(params);
            JsonParse jsonParse = new JsonParse();

            Map requestWord = jsonParse.parseResponse("userRequest",jsonInString);

            String city = requestWord.get("utterance").toString();

            JSONObject coordinate = apiCall.apiCall(city);

            Map weatherInfo = apiCall.temperatureApi(coordinate.get("lat").toString(),coordinate.get("lng").toString());

            HashMap<String, String> temp= (HashMap<String,String>)weatherInfo.get("temp");

            logger.info(temp.toString());

            String weatherText = String.format("현재 온도 : %s \n 최고 온도 : %s ",
                    temp.get("temp"), temp.get("temp_max"));

            logger.info(weatherText);


            List<HashMap<String,Object>> outputs = new ArrayList<>();
            HashMap<String,Object> template = new HashMap<>();
            HashMap<String, Object> simpleText = new HashMap<>();
            HashMap<String, Object> text = new HashMap<>();

            text.put("text",weatherText);
            simpleText.put("simpleText",text);
            outputs.add(simpleText);

            template.put("outputs",outputs);

            resultJson.put("version","2.0");
            resultJson.put("template",template);

        }catch (Exception e){
            e.getStackTrace();
        }

        return resultJson;
    }

}
