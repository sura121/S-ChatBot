package com.sura.service;

import com.sura.domain.BoardVO;
import com.sura.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

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
