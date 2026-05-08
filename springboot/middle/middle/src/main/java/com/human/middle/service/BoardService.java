package com.human.middle.service;

import com.human.middle.dao.BoardDao;
import com.human.middle.dto.Board;
import com.human.middle.dto.CustomUser;
import com.human.middle.dto.request.BoardWriteReq;
import com.human.middle.dto.response.BoardResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDao boardDao;

    @Transactional
    public boolean boardSave(BoardWriteReq boardWriteReq){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof CustomUser){
            Long memberId = ((CustomUser) principal).getMemberId();
            return boardDao.boardSave(boardWriteReq.toEntity(memberId));
        }
        throw new RuntimeException("로그인이 필요합니다.");
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
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(principal instanceof CustomUser)){
            throw new RuntimeException("로그인이 필요합니다.");
        }
        Long memberId = ((CustomUser) principal).getMemberId();

        Board board = boardDao.boardDetail(boardId).orElseThrow(() -> new IllegalArgumentException("존재하지않는 게시물 입니다."));

        if(!(Objects.equals(board.getMemberId(), memberId))){
            throw new IllegalArgumentException("본인이 작성한 글만 수정할수 있습니다.");
        }

        return boardDao.boardFix(boardWriteReq.toEntity(memberId));
    }
    @Transactional
    public boolean boardDel(Long boardId){
        boolean del = boardDao.boardDel(boardId);
        if(!del) throw new RuntimeException("삭제중 에러 발생");
        return true;
    }
}
