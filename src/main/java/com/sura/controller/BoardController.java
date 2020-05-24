package com.sura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    @RequestMapping(value = "/test")
    public String main()
    {
        System.out.println("dfadsfsd");
        return "test1.html";
    }
}
