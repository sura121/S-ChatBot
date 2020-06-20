package com.sura.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class RequestKeyword {

    private final static Logger logger = LoggerFactory.getLogger(RequestKeyword.class);

    @Pointcut("execution(public * com.sura.controller.SChatBotController.*(..))")
    public void getParameter() {}

    @Before(value = "getParameter() && args(params,..)")
    public void parameterRequest(Map<String, Object> params) {

        logger.info(params.toString());
    }

}
