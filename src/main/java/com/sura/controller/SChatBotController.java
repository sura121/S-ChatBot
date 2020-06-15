package com.sura.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.domain.TemperatureVO;
import com.sura.global.ApiCall;
import com.sura.global.CalcTemp;
import com.sura.global.JsonParse;
import com.sura.resource.Cities;
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
            String weatherText;
            String weatherImage;
            String city = requestWord.get("utterance").toString();

            Cities cityConfirm = Cities.findByCity(city);

            if(cityConfirm == null) {
                weatherText = "검색 불가능한 도시 입니다.";
                weatherImage="";
            } else {

                JSONObject coordinate = apiCall.apiCall(city);

                Map weatherInfo = apiCall.temperatureApi(coordinate.get("lat").toString(),coordinate.get("lng").toString());

                HashMap<String, String> temp= (HashMap<String,String>)weatherInfo.get("temp");
                HashMap<String, String> mainWeather= (HashMap<String,String>)weatherInfo.get("weather");

                logger.info(temp.toString());

                weatherText = String.format("현재 날씨 : %s \uD83D\uDCB3\uD83D\uDCB3\uD83D\uDCB3 \n현재 온도 : %s \n최고 온도 : %s ",
                        mainWeather.get("description"),temp.get("temp"), temp.get("temp_max"));

                logger.info(weatherText);

                weatherImage ="https://post-phinf.pstatic.net/MjAxNzA3MjVfMSAg/MDAxNTAwOTY2NTAwOTQz.BVp-6W0YgOG9hEUSRaORj5diLQUItrXKYTuEsTrAJFwg.zUGDnU9F1qPyOVJDIk4Gux8zDL4r1OCYnMZHXnt3yS4g.PNG/image.png?type=w1200";

            }

            List<HashMap<String,Object>> outputs = new ArrayList<>();
            HashMap<String,Object> template = new HashMap<>();
            HashMap<String, Object> simpleText = new HashMap<>();
            HashMap<String, Object> context = new HashMap<>();
            HashMap<String, Object> simpleImage = new HashMap<>();
            HashMap<String, Object> imageUrl = new HashMap<>();
            HashMap<String, Object> basicCard = new HashMap<>();

            basicCard.put("title","날씨정보입니다.");
            basicCard.put("description",weatherText);

//            text.put("text",weatherText);
//            simpleText.put("simpleText",text);
            imageUrl.put("imageUrl",weatherImage);
            basicCard.put("thumbnail",imageUrl);
            context.put("basicCard",basicCard);
            outputs.add(context);
//            outputs.add(simpleImage);

            template.put("outputs",outputs);

            resultJson.put("version","2.0");
            resultJson.put("template",template);

        }catch (Exception e){
            e.getStackTrace();
        }

        return resultJson;
    }

}
