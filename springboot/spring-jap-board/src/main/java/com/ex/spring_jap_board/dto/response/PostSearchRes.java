package com.ex.spring_jap_board.dto.response;

import com.ex.spring_jap_board.entity.Post;
import lombok.*;
import org.springframework.security.core.parameters.P;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchRes {
    private Long postId;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;

    public static PostSearchRes of(Post post){
        PostSearchRes postSearchRes = new PostSearchRes();
        postSearchRes.setPostId(post.getPostId());
        postSearchRes.setTitle(post.getTitle());
        postSearchRes.setContent(post.getContent());
        postSearchRes.setWriter(post.getMember().getMemberName());
        postSearchRes.setCreatedAt(post.getCreatedAt());
        return postSearchRes;
    }
}
