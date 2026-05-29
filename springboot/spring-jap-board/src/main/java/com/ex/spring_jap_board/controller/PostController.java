package com.ex.spring_jap_board.controller;

import com.ex.spring_jap_board.dto.request.PostRegReq;
import com.ex.spring_jap_board.dto.request.PostUpReq;
import com.ex.spring_jap_board.dto.response.ApiResponse;
import com.ex.spring_jap_board.dto.response.PostDetailRes;
import com.ex.spring_jap_board.dto.response.PostSearchRes;
import com.ex.spring_jap_board.entity.Post;
import com.ex.spring_jap_board.security.CustomUserDetail;
import com.ex.spring_jap_board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<Page<PostSearchRes>>> showAll(
            @PageableDefault(size = 10, sort = "postId", direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        Page<PostSearchRes> postList = postService.showAll(pageable);
        return ResponseEntity.ok(ApiResponse.ok("전체 게시물 조회 성공", postList));
    }

    @GetMapping("/detail/{postId}")
    public ResponseEntity<ApiResponse<PostDetailRes>> findById(@PathVariable Long postId){
        PostDetailRes res = postService.findById(postId);
        return ResponseEntity.ok(ApiResponse.ok("게시글 상세 성공", res));
    }

    @PostMapping("/write")
    public ResponseEntity<ApiResponse<Void>> insertPost(@RequestBody PostRegReq req, @AuthenticationPrincipal CustomUserDetail userDetail){
        postService.insertPost(req, userDetail.getMemberId());
        return ResponseEntity.ok(ApiResponse.ok( "게시글 작성 완료", null));
    }

    @PostMapping("/update/{postId}")
    public ResponseEntity<ApiResponse<Void>> updatePost(@RequestBody PostUpReq req, @AuthenticationPrincipal CustomUserDetail userDetail,
                                                            @PathVariable Long postId){
        postService.updatePost(req, userDetail.getMemberId(), postId);
        return ResponseEntity.ok(ApiResponse.ok("게시글 수정 완료", null));
    }

    @PostMapping("/delete/{postId}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long postId, @AuthenticationPrincipal CustomUserDetail userDetail){
        postService.deletePost(postId, userDetail.getMemberId());
        return ResponseEntity.ok(ApiResponse.ok("게시글 삭제 완료", null));
    }
}
