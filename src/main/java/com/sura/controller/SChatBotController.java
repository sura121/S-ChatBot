package com.sura.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.domain.ResponseVO;
import com.sura.domain.component.CitiesView;
import com.sura.domain.component.SimpleTextView;
import com.sura.domain.subtype.SimpleText;
import com.sura.domain.subtype.Template;
import com.sura.domain.subtype.Text;
import com.sura.global.ApiCall;
import com.sura.global.JsonParse;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
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

            logger.info("response data");
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

        logger.info("스킬블록 추가 in...");

        Object citiesView = new Object();


        String word = (String) request.getAttribute("city");

        try {

            citiesView = apiCall.reponseApiCall(word);



        }catch (Exception e) {
            e.getStackTrace();
        }

        return ResponseEntity.ok(citiesView);
    }

    @RequestMapping(value = "/kakaoChat/cities", headers = {"Accept=application/json"})
    public ResponseVO City(HttpServletRequest request, HttpServletResponse response) {

        ResponseVO vo = new ResponseVO("2.0");
        SimpleText smp = new SimpleText("테스트입니다.");
        SimpleTextView smv = new SimpleTextView(smp);

        Template tmp = Template.builder()
                .outputs(Collections.singletonList(smv))
                .build();

        vo.setTemplate(tmp);

        return vo;
    }


}
