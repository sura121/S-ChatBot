package com.sura.controller;

import com.sura.domain.BoardVO;
import com.sura.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    private final Logger logger =  LoggerFactory.getLogger(BoardController.class);

    @RequestMapping(value = "/test")
    public String main()
    {
        System.out.println("dfadsfsd");
        logger.info("Asd");
        return "test1";
    }

    @GetMapping(value = "/list")
    public String list(Model model) throws Exception {

        Iterable<BoardVO> list = boardService.selectList();

        logger.info(list.toString());
        try {
            model.addAttribute("list",list);
            System.out.println(list.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }

        return "list";
    }

    @ResponseBody
    @GetMapping(value = "/list/{pk}")
    public ResponseEntity<?> getById(@PathVariable("pk") Long id) {
        BoardVO vo = boardService.selectOne(id);

        return ResponseEntity.ok(vo);
    }

}
