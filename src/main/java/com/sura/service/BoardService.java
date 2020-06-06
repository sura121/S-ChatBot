package com.sura.service;

import com.sura.domain.BoardVO;
import com.sura.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.*;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Long SavePost(BoardVO boardVO) {

        return boardRepository.save(boardVO).getPk();
    }

    public Iterable<BoardVO> selectList(){


        Iterable<BoardVO> board = boardRepository.findAll();
        System.out.println(board.toString());
//        boardRepository.findAll().forEach(e -> board.add(e));
        return board;
    }

    public BoardVO selectOne(Long pk) {
        BoardVO vo = boardRepository.findByPk(pk);
        return vo;
    }




}
