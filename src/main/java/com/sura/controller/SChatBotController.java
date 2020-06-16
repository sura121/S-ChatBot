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
import org.springframework.http.ResponseEntity;
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
     * refactoring complete
     * @param params
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/kkoChat/v1" , method= {RequestMethod.POST , RequestMethod.GET },headers = {"Accept=application/json"})
    public ResponseEntity<?> WeatherBot(@RequestBody Map<String,Object> params, HttpServletRequest request , HttpServletResponse response) {

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

            String city = requestWord.get("utterance").toString();

            vo = apiCall.reponseApiCall(city);

        }catch (Exception e){
            e.getStackTrace();
        }

        return ResponseEntity.ok(vo);
    }

}
