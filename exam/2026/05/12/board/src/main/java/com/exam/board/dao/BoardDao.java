package com.exam.board.dao;

import com.exam.board.dto.Board;

import java.util.List;
import java.util.Optional;

public interface BoardDao {
    public List<Board> findAll();

    public Optional<Board> findById(Long boardId);

    public void save(Board board);

    public void update(Board board);

    public void delete(Long boardId);
}
