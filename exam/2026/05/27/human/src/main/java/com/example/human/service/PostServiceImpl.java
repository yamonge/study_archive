package com.example.human.service;

import com.example.human.dto.response.PostSearchRes;
import com.example.human.entity.Post;
import com.example.human.exception.CustomException;
import com.example.human.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostSearchRes findById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "존재하지 않는 게시글입니다."));

        return PostSearchRes.from(post);
    }

    @Override
    public List<PostSearchRes> showAll() {
        return postRepository.findAll().stream()
                .map(PostSearchRes::from)
                .toList();
    }

    @Override
    @Transactional
    public void deletePost(Long postId, Long memberId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "존재하지 않는 게시글입니다."));

        if (post.getMember() == null || !post.getMember().getMemberId().equals(memberId)) {
            throw new CustomException(HttpStatus.FORBIDDEN, "삭제 권한이 없습니다.");
        }

        postRepository.delete(post);
    }
}