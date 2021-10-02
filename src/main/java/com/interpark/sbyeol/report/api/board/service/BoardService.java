package com.interpark.sbyeol.report.api.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.interpark.sbyeol.report.api.board.controller.BoardController;
import com.interpark.sbyeol.report.api.board.model.Board;
import com.interpark.sbyeol.report.api.board.repository.BoardRepository;

@Service
public class BoardService implements BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<Board> getList() {
        return boardRepository.findAll();
    }

    @Override
    public Board get(@PathVariable Long seq) {
    	Optional<Board> board = boardRepository.findById(seq);
        return board.get();
    }

    @Override
    public ResponseEntity<?> post( @RequestBody Board request) {
    	boardRepository.save(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> put(@PathVariable Long seq,  @RequestBody Board request) {
    	Optional<Board> board = boardRepository.findById(seq);
    	 
    	board.ifPresent(updateBoard ->{
    		updateBoard.setTitle(request.getTitle());
    		updateBoard.setContents(request.getContents());
    		boardRepository.save(updateBoard);
        });
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(@PathVariable Long seq) {
    	Optional<Board> board = boardRepository.findById(seq);
    	board.ifPresent(deleteBoard ->{
    		boardRepository.delete(deleteBoard);
        });
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

