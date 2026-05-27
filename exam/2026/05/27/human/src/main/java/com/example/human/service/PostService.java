package com.example.human.service;

import com.example.human.dto.response.PostSearchRes;

import java.util.List;

public interface PostService {

    PostSearchRes findById(Long postId);

    List<PostSearchRes> showAll();

    void deletePost(Long postId, Long memberId);
}