package com.exam.board.dao;

import com.exam.board.dto.Board;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoardDaoImpl implements BoardDao{

    private final JdbcTemplate jdbcTemplate;

    public BoardDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Board> findAll(){
        String sql = "SELECT * FROM BOARD ORDER BY CREATE_AT DESC";
        List<Board> boards = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Board.class));
        return boards;
    }

    @Override
    public Optional<Board> findById(Long boardId){
        String sql = "SELECT * FROM BOARD WHERE BOARD_ID = ?";
        List<Board> board = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Board.class), boardId);
        return board.stream().findAny();
    }

    @Override
    public void save(Board board){
        String sql = "INSERT INTO BOARD(BOARD_ID, TITLE, CONTENT, MEMBER_ID) " +
                        "VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?)";
        int rst = jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getMemberId());
    }

    @Override
    public void update(Board board){
        String sql = "UPDATE BOARD " +
                        "SET TITLE = ?, CONTENT = ?, MEMBER_ID = ? " +
                        "WHERE BOARD_ID = ?";
        int rst = jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getMemberId(), board.getBoardId());
    }

    @Override
    public void delete(Long boardId){
        String sql = "DELETE FROM BOARD " +
                        "WHERE BOARD_ID = ?";
        int rst = jdbcTemplate.update(sql, boardId);
    }
}

