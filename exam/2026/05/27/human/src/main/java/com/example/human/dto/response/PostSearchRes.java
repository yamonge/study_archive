package com.example.human.dto.response;

import com.example.human.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostSearchRes {

    private Long postId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Long memberId;
    private String memberEmail;

    public static PostSearchRes from(Post post) {
        return new PostSearchRes(
                post.getPostId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getMember() != null ? post.getMember().getMemberId() : null,
                post.getMember() != null ? post.getMember().getMemberEmail() : null
        );
    }
}