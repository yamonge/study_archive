package com.ex.spring_jap_board.dto.response;

import com.ex.spring_jap_board.entity.Post;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailRes {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String imgUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PostDetailRes of(Post post){
        PostDetailRes postDetailRes = new PostDetailRes();
        postDetailRes.setId(post.getPostId());
        postDetailRes.setTitle(post.getTitle());
        postDetailRes.setContent(post.getContent());
        postDetailRes.setWriter(post.getMember().getMemberName());
        postDetailRes.setImgUrl(post.getPostImgUrl());
        postDetailRes.setCreatedAt(post.getCreatedAt());
        postDetailRes.setUpdatedAt(post.getUpdatedAt());
        return postDetailRes;
    }
}
