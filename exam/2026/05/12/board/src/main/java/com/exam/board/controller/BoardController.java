package com.exam.board.controller;

import com.exam.board.dto.Board;
import com.exam.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Board> boards = boardService.showAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable Long id){
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/view";
    }
}
