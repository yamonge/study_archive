package com.exam.board.dto;

import java.time.LocalDateTime;

public class Board {
    private Long boardId;
    private String title;
    private String content;
    private Long memberId;
    private int viewCount;
    private LocalDateTime createAt;

    public Board(){

    }

    public Board(Long boardId, String title, String content, Long memberId, int viewCount, LocalDateTime createAt) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.viewCount = viewCount;
        this.createAt = createAt;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
