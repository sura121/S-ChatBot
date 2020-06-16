package com.sura.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.domain.ResponseVO;
import com.sura.domain.TemperatureVO;
import com.sura.domain.subtype.Template;
import com.sura.global.ApiCall;
import com.sura.global.CalcTemp;
import com.sura.global.JsonParse;
import com.sura.resource.Cities;
import com.sura.resource.ConfigResource;
import com.sura.resource.ImageUrl;
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


    /**
     * FIXME: refactoring 필요 부분
     * @param params
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/kkoChat/v1" , method= {RequestMethod.POST , RequestMethod.GET },headers = {"Accept=application/json"})
    public ResponseVO WeatherBot(@RequestBody Map<String,Object> params, HttpServletRequest request , HttpServletResponse response) {

        HashMap<String, Object> resultJson = new HashMap<>();

        ResponseVO vo = new ResponseVO("2.0");

        try{

            /**
             * @param weather api param city
             * function ApiCall() 리팩토링 함수 추가
             */

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(params);
            JsonParse jsonParse = new JsonParse();

            Map requestWord = jsonParse.parseResponse("userRequest",jsonInString);
//            String weatherText;
//            String weatherImage;
            String city = requestWord.get("utterance").toString();

            vo = apiCall.reponseApiCall(city);

//            Cities cityConfirm = Cities.findByCity(city);
//
//            if(cityConfirm == null) {
//                weatherText = "검색 불가능한 도시 입니다.";
//                weatherImage="";
//            } else {
//
//                JSONObject coordinate = apiCall.apiCall(city);
//
//                Map weatherInfo = apiCall.temperatureApi(coordinate.get("lat").toString(),coordinate.get("lng").toString());
//
//                HashMap<String, String> temp= (HashMap<String,String>)weatherInfo.get("temp");
//                HashMap<String, String> mainWeather= (HashMap<String,String>)weatherInfo.get("weather");
//
//                logger.info(temp.toString());
//
//                HashMap<String, String> imgInfo = ImageUrl.findByGetEmoji(mainWeather.get("description"));
//
//                logger.info("image Info select : "+imgInfo.toString());
//
//                weatherText = String.format("현재 날씨 : %s %s  \n현재 온도 : %s \n최고 온도 : %s ",
//                        mainWeather.get("description"),imgInfo.get("emoji"),temp.get("temp"), temp.get("temp_max"));
//
//
//                logger.info(weatherText);
//
//                weatherImage ="https://post-phinf.pstatic.net/MjAxNzA3MjVfMSAg/MDAxNTAwOTY2NTAwOTQz.BVp-6W0YgOG9hEUSRaORj5diLQUItrXKYTuEsTrAJFwg.zUGDnU9F1qPyOVJDIk4Gux8zDL4r1OCYnMZHXnt3yS4g.PNG/image.png?type=w1200";
//
//            }
//
            /**
             * TODO : domain 처리로 변경 필요
             * ResponseVO
             */
//            List<HashMap<String,Object>> outputs = new ArrayList<>();
//            HashMap<String,Object> template = new HashMap<>();
//            HashMap<String, Object> context = new HashMap<>();
//            HashMap<String, Object> imageUrl = new HashMap<>();
//            HashMap<String, Object> basicCard = new HashMap<>();
//
//            basicCard.put("title","날씨정보입니다.");
//            basicCard.put("description",weatherText);
//
//            imageUrl.put("imageUrl",weatherImage);
//            basicCard.put("thumbnail",imageUrl);
//            context.put("basicCard",basicCard);
//            outputs.add(context);
//
//            template.put("outputs",outputs);
//
//            resultJson.put("version","2.0");
//            resultJson.put("template",template);

        }catch (Exception e){
            e.getStackTrace();
        }
        logger.info(vo.toString());
        return vo;
    }

}
