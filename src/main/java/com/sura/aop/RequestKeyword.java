package com.sura.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.global.JsonParse;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
public class RequestKeyword {

    private final static Logger logger = LoggerFactory.getLogger(RequestKeyword.class);

    @Pointcut("execution( * com.sura.controller.SChatBotController.*(..))")
    public void getParameter() {}

    @Before(value = "getParameter() && args(params,request,..)")
    public void parameterRequest(Map<String, Object> params, HttpServletRequest request) throws Throwable {

//        ObjectMapper mapper = new ObjectMapper();
//        String jsonInString = mapper.writeValueAsString(params);
//        JsonParse jsonParse = new JsonParse();
//
//        Map requestWord = jsonParse.parseResponse("userRequest",jsonInString);
//
//        String city = requestWord.get("utterance").toString();
//
//        request.setAttribute("city",city);

//        logger.info("AOP : " + city);

    }

}
