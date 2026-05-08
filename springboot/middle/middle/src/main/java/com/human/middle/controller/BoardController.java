package com.human.middle.controller;

import com.human.middle.dto.request.BoardWriteReq;
import com.human.middle.dto.response.BoardResponse;
import com.human.middle.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/write")
    public ResponseEntity<?> write(@Valid @RequestBody BoardWriteReq req){
        boardService.boardSave(req);
        return ResponseEntity.ok("게시글 작성 완료");
    }

    @GetMapping("/detail/{boardId}")
    public ResponseEntity<?> detail(@PathVariable Long boardId){
        BoardResponse boardResponse = boardService.boardDetail(boardId);
        return ResponseEntity.ok(boardResponse);
    }

    @GetMapping("/showAll")
    public ResponseEntity<?> showAll(){
        List<BoardResponse> boards = boardService.boardAll();
        return ResponseEntity.ok(boards);
    }

    @PostMapping("/fix/{boardId}")
    public ResponseEntity<?> fix(@PathVariable Long boardId, @Valid @RequestBody BoardWriteReq req){
        boardService.boardFix(req, boardId);
        return ResponseEntity.ok("수정이 완료되었습니다");
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> del(@PathVariable Long boardId){
        boardService.boardDel(boardId);
        return ResponseEntity.ok("삭제가 완료 되었습니다.");
    }
}
