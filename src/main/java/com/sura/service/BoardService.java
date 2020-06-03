package com.sura.service;

import com.sura.domain.BoardVO;
import com.sura.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Transactional
    public Long SavePost(BoardVO boardVO) {

        return boardRepository.save(boardVO).getPk();
    }

    public List<BoardVO> selectList(){

        List<BoardVO> board = new ArrayList<>();
        boardRepository.findAll().forEach(e -> board.add(e));
        return board;
    }



}
