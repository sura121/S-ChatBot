package com.sura.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.domain.ResponseVO;
import com.sura.global.ApiCall;
import com.sura.global.JsonParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
