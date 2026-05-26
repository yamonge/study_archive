package com.ex.spring_jap_board.dto.request;

import com.ex.spring_jap_board.entity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PostUpReq {
    private Long id;
    private String title;
    private String content;

    public static Post toEntity(PostUpReq req){
        Post post = new Post();
        post.setPostId(req.getId());
        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        return post;
    }
}
