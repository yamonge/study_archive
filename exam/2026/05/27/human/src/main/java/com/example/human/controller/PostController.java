package com.example.human.controller;

import com.example.human.common.ApiResponse;
import com.example.human.dto.response.PostSearchRes;
import com.example.human.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse<PostSearchRes>> findById(@PathVariable Long postId) {
        PostSearchRes result = postService.findById(postId);

        return ResponseEntity.ok(
                ApiResponse.ok("게시글 조회 성공", result)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostSearchRes>>> showAll() {
        List<PostSearchRes> result = postService.showAll();

        return ResponseEntity.ok(
                ApiResponse.ok("게시글 전체 조회 성공", result)
        );
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse<Void>> deletePost(
            @PathVariable Long postId,
            @RequestParam Long memberId
    ) {
        postService.deletePost(postId, memberId);

        return ResponseEntity.ok(
                ApiResponse.ok("게시글 삭제 성공", null)
        );
    }
}