package com.sura.controller;

import com.sura.domain.BoardVO;
import com.sura.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {

    private final static Logger logger = LoggerFactory.getLogger(BoardControllerTest.class);

    @MockBean
    private BoardService boardService;

    @Test
    public void getById() throws Exception{

        try{
            BoardVO board = boardService.selectOne((long)1);
            if(board == null) {
                board = new BoardVO();
            }
            logger.info(board.toString());
            logger.info("Asdasd");
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

}

