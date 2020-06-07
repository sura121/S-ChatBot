package com.sura.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import com.sura.domain.MessageVO;
import com.sura.service.MessageService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chat")
public class SChatBotController {

    private final static Logger logger = LoggerFactory.getLogger(SChatBotController.class);

    @Autowired
    private MessageService messageService;

    @SneakyThrows
    @RequestMapping(value = "/kkoChat/v1" , method= {RequestMethod.POST , RequestMethod.GET },headers = {"Accept=application/json"})
    public Map<String,Object> HelloBot(@RequestBody Map<String,Object> params, HttpServletRequest request , HttpServletResponse response) {

        Map<String, Object> resultJson = new HashMap<>();

        ObjectMapper mapper = new ObjectMapper();
        String reqJson = mapper.writeValueAsString(params);
        logger.info(reqJson);

        List<Map<String,Object>> outputs = new ArrayList<>();

        Map<String,Object> simpleText = new HashMap<>();
        Map<String,Object> text = new HashMap<>();
        Map<String,Object> template = new HashMap<>();

        text.put("text","안녕하세요.");

        simpleText.put("simpleText",text);
        outputs.add(simpleText);
        template.put("output",outputs);

        resultJson.put("version","1.0");
        resultJson.put("template",template);

        return resultJson;
    }

}
