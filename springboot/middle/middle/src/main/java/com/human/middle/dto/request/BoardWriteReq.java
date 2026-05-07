package com.human.middle.dto.request;

import com.human.middle.dto.Board;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class BoardWriteReq {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public Board toEntity(Long memberId){
        return Board.builder()
                .title(this.title)
                .content(this.content)
                .memberId(memberId)
                .build();
    }

    public Board toEntity(Long memberId, Long boardId){
        return Board.builder()
                .boardId(boardId)
                .title(this.title)
                .content(this.content)
                .memberId(memberId)
                .build();
    }
}
