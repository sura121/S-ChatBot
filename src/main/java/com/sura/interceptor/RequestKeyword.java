package com.sura.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Aspect
@Component
public class RequestKeyword {

    private final static Logger logger = LoggerFactory.getLogger(RequestKeyword.class);

    @Pointcut("execution(public * com.sura.controller.SChatBotController.*(..))")
    public void getParameter() {}

    @Before(value = "getParameter()")
    public void parameterRequest() {

        logger.info("test aop");
    }

}
