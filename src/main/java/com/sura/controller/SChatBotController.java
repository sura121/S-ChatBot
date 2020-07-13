package com.sura.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.domain.ResponseVO;
import com.sura.domain.component.CitiesView;
import com.sura.global.ApiCall;
import com.sura.global.JsonParse;
import org.apache.commons.io.IOUtils;
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

    private final static String DOSI = "도시";

    @Autowired
    private ApiCall apiCall;


    /**
     * refactoring complete
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/kkoChat/v1" , method= {RequestMethod.POST , RequestMethod.GET },headers = {"Accept=application/json"})
    public ResponseEntity<?> WeatherBot( HttpServletRequest request , HttpServletResponse response) throws Exception {

        ResponseVO vo = new ResponseVO("2.0");

        String city = (String) request.getAttribute("city");

        try{

            vo = (ResponseVO)apiCall.reponseApiCall(city);

            logger.info(vo.toString());

        }catch (Exception e){
            e.getStackTrace();
        }

        return ResponseEntity.ok(vo);
    }

    /**
     * 발화 코드 추가 controller
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/kkoChat/cities" , method= {RequestMethod.POST , RequestMethod.GET },headers = {"Accept=application/json"})
    public ResponseEntity<?> Cities(HttpServletRequest request , HttpServletResponse response) {

        Object citiesView = new Object();


        String word = (String) request.getAttribute("city");

        try {

            citiesView = apiCall.reponseApiCall(word);



        }catch (Exception e) {
            e.getStackTrace();
        }
        logger.info(citiesView.toString());
        return ResponseEntity.ok(citiesView);
    }

}
