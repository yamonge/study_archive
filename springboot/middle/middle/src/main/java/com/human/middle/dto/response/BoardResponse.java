package com.human.middle.dto.response;

import com.human.middle.dto.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {
    private Long id;
    private String title;
    private String content;
    private Long writer;
    private String writerName;
    private int viewCount;
    private LocalDateTime createAt;

    public static BoardResponse of(Board board){
        BoardResponse boardResponse = new BoardResponse();
        boardResponse.setId(board.getBoardId());
        boardResponse.setContent(board.getContent());
        boardResponse.setTitle(board.getTitle());
        boardResponse.setWriter(board.getMemberId());
        boardResponse.setWriterName(board.getWriter());
        boardResponse.setViewCount(board.getViewCount());
        boardResponse.setCreateAt(board.getCreateAt());
        return boardResponse;
    }

}
