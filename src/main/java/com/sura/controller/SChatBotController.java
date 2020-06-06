package com.sura.controller;

import com.sura.domain.MessageVO;
import com.sura.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class SChatBotController {

    private final static Logger logger = LoggerFactory.getLogger(SChatBotController.class);

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/hello")
    public MessageVO HelloBot() {
        MessageVO message = new MessageVO();

        message.setText("hello");
        return message;
    }

}
