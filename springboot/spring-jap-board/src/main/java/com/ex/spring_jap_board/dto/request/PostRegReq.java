package com.ex.spring_jap_board.dto.request;

import com.ex.spring_jap_board.entity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostRegReq {
    private String title;
    private String content;

    public static Post toEntity(PostRegReq req){
        Post post = new Post();
        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        return post;
    }
}
