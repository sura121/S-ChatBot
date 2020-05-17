package com.sura.controller;

import com.sura.domain.MessageVO;
import com.sura.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private LogService log;

    @GetMapping(value = "/message/{id}")
    public ResponseEntity<?> newsSerach(@PathVariable Integer id) {

        log.getLogger("in controller");

        MessageVO message = new MessageVO();
        message.setCode(200);
        message.setDesc("asd");
        message.setId(id);
        message.setQuantity(10);

        return ResponseEntity.ok(message);
    }
}
