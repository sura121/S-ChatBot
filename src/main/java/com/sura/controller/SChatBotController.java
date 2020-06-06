package com.sura.controller;

import com.sura.domain.MessageVO;
import com.sura.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "/hello")
    public MessageVO HelloBot() {
        MessageVO message = new MessageVO();

        message.setVersion("2.0");
        List<Map<String,Object>> outputs = new ArrayList<>();

        Map<String,Object> simpleText = new HashMap<>();
        Map<String,Object> text = new HashMap<>();
        Map<String,Object> template = new HashMap<>();

        text.put("text","안녕하세요.");

        simpleText.put("simpleText",text);
        outputs.add(simpleText);
        template.put("output",outputs);
        message.setTemplate(template);

        return message;
    }

}
