package com.board.board.service;

import com.board.board.entity.board;
import com.board.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    public void write(board board){

        boardRepository.save(board);

    }

    public List<board> boardList(){
        return boardRepository.findAll();
    }

    public board boardview(Integer id){
        return boardRepository.findById(id).get();
    }

}
