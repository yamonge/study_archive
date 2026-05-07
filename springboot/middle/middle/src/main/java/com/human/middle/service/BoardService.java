package com.human.middle.service;

import com.human.middle.dao.BoardDao;
import com.human.middle.dto.Board;
import com.human.middle.dto.request.BoardWriteReq;
import com.human.middle.dto.response.BoardResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDao boardDao;

    @Transactional
    public boolean boardSave(BoardWriteReq boardWriteReq){
        Long memberId = 100L; // 시큐리티에서 실제로 빼옴
        Board board = boardWriteReq.toEntity(memberId);
        boolean save = boardDao.boardSave(board);
        if(!save) throw new RuntimeException("저장중 에러 발생");
        return true;
    }

    public BoardResponse boardDetail(Long boardId){
        Board board = boardDao.boardDetail(boardId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 입니다."));

        return BoardResponse.of(board);
    }

    public List<BoardResponse> boardAll(){
        List<Board> boards = boardDao.boardList();

        if(boards.isEmpty()) {
            throw new IllegalArgumentException("게시물이 존재 하지 않습니다.");
        }
        return boards.stream()
                .map(BoardResponse::of)
                .toList();
    }
    @Transactional
    public boolean boardFix(BoardWriteReq boardWriteReq, Long boardId){
        Long memberId = 100L; // 시큐리티에서 실제로 빼옴
        Board board = boardWriteReq.toEntity(memberId, boardId);
        boolean fix = boardDao.boardFix(board);
        if(!fix) throw new RuntimeException("수정중 에러가 발생했습니다.");
        return true;
    }
    @Transactional
    public boolean boardDel(Long boardId){
        boolean del = boardDao.boardDel(boardId);
        if(!del) throw new RuntimeException("삭제중 에러 발생");
        return true;
    }
}
