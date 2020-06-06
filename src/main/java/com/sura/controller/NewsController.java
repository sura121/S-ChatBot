package com.sura.controller;

import com.google.gson.JsonElement;
import com.sura.domain.MessageVO;
import com.sura.service.LogService;
import groovyjarjarantlr.debug.MessageAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private LogService log;

    @GetMapping(value = "/message/{id}")
    public ResponseEntity<?> newsSerach(@PathVariable Integer id) {

        log.getLogger("in controller");

        MessageVO message = new MessageVO();


        return ResponseEntity.ok(message);
    }

    @PostMapping(value = "/message/add")
    public ResponseEntity<?> addNews(@RequestBody MessageVO vo) {


        MessageVO message = new MessageVO();

        return  ResponseEntity.ok(message);
    }

    @GetMapping(value = "/message")
    public ResponseEntity<?> allSearch() {

        List<MessageVO> message = new ArrayList<>();
        return ResponseEntity.ok(message);
    }
}
