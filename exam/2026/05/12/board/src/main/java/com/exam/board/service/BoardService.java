package com.exam.board.service;

import com.exam.board.dao.BoardDao;
import com.exam.board.dto.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardDao boardDao;

    public BoardService(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    public List<Board> showAll(){
        List<Board> boards = boardDao.findAll();
        return boards;
    }

    public Board findById(Long boardId){
        Board board = boardDao.findById(boardId).orElseThrow(() -> new IllegalArgumentException("맞는 보드가 없습니다"));
        return board;
    }

    public void save(Board board){
        boardDao.save(board);
    }

    public void update(Board board){
        boardDao.update(board);
    }

    public void delete(Long boardId){
        boardDao.delete(boardId);
    }
}
