package com.human.middle.dao;

import com.human.middle.dto.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardDao {
    private final JdbcTemplate jdbcTemplate;

    // 게시물 작성
    public boolean boardSave(Board board){
        String sql = "INSERT INTO BOARD(board_id, title, content, member_id) VALUES(board_seq.NEXTVAL, ?, ?, ?)";
        int save = jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getMemberId());
        return save > 0;
    }
    // 게시물 개별 조회
    public Optional<Board> boardDetail(Long boardId){
        String sql =  "SELECT B.board_id, B.title, B.content, B.member_id, M.username as writer, B.view_count, B.create_at" +
                        "FROM BOARD B JOIN MEMBER M ON B.member_id = M.member_id " +
                        "WHERE B.board_id = ?";
        List<Board> boards = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Board.class), boardId);
        return boards.stream().findFirst();
    }
    // 게시물 전체 조회
    public List<Board> boardList(){
        String sql = "SELECT B.board_id, B.title, B.content, B.member_id, M.username as writerName B.view_count, B.create_at" +
                    "FROM BOARD B JOIN MEMBER M ON B.member_id = M.member_id ";
        List<Board> boards = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Board.class));
        return boards;
    }
    // 게시물 수정
    public boolean boardFix(Board board){
        String sql = "UPDATE BOARD SET title = ?, content = ? WHERE board_id = ?";
        int fix = jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getBoardId());
        return fix > 0;
    }
    // 게시물 삭제
    public boolean boardDel(Long boardId){
        String sql = "DELETE FROM BOARD WHERE board_id = ?";
        int del = jdbcTemplate.update(sql, boardId);
        return del > 0;
    }
}
