package com.sura.controller;

import com.google.gson.JsonElement;
import com.sura.domain.MessageVO;
import com.sura.resource.Cities;
import com.sura.service.LogService;
import groovyjarjarantlr.debug.MessageAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private LogService log;

    @RequestMapping(value = "/message/{id}")
    public ResponseEntity<?> newsSerach(@PathVariable Integer id) {

        log.getLogger("in controller");

        MessageVO message = new MessageVO();


        return ResponseEntity.ok(message);
    }

    @RequestMapping(value = "/message/add")
    public ResponseEntity<?> addNews(@RequestBody MessageVO vo) {


        MessageVO message = new MessageVO();

        return  ResponseEntity.ok(message);
    }

    @RequestMapping(value = "/message")
    public ResponseEntity<?> allSearch() {

        List<MessageVO> message = new ArrayList<>();
        return ResponseEntity.ok(message);
    }

    @RequestMapping(value = "/enumtest/{citis}")
    public void enumTest(@PathVariable("citis") String city)
    {
        Cities citi = Cities.findByCity(city);

        System.out.println(citi);

//        Cities[] cities = Cities.class.getEnumConstants();
//        Arrays.asList(cities).stream().forEach(e->{
//            String city = e.getCity();
//            System.out.println(city);
//        });
    }
}
