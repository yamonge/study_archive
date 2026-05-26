package com.ex.spring_jap_board.service;

import com.ex.spring_jap_board.dto.request.PostRegReq;
import com.ex.spring_jap_board.dto.request.PostSearchReq;
import com.ex.spring_jap_board.dto.request.PostUpReq;
import com.ex.spring_jap_board.dto.response.PostDetailRes;
import com.ex.spring_jap_board.dto.response.PostSearchRes;
import com.ex.spring_jap_board.entity.Member;
import com.ex.spring_jap_board.entity.Post;
import com.ex.spring_jap_board.exception.CustomException;
import com.ex.spring_jap_board.repository.MemberRepository;
import com.ex.spring_jap_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    // 게시글 전체 조회
    @Transactional(readOnly = true)
    public List<PostSearchRes> showAll(){
        return postRepository.findAll().stream()
                .map(PostSearchRes::of)
                .toList();
    }
    // 개별 게시글 조회
    @Transactional(readOnly = true)
    public PostDetailRes findById(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "해당 게시글을 찾을수 없습니다"));
        return PostDetailRes.of(post);
    }
    // 게시글 작성(추후 이미지 파일 추가 예정)
    @Transactional
    public void insertPost(PostRegReq req, Long memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "존재하지 않는 회원 입니다."));

        Post post = PostRegReq.toEntity(req);
        post.setMember(member);
        postRepository.save(post);
    }

    // 게시글 수정
    @Transactional
    public void updatePost(PostUpReq req, Long memberId, Long postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "존재하지 않는 게시글 입니다."));

        if(!post.getMember().getMemberId().equals(memberId)){
            throw new CustomException(HttpStatus.FORBIDDEN, "수정 권한이 없습니다.");
        }

        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
    }

    // 게시글 삭제
    @Transactional
    public void deletePost(Long postId, Long memberId){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "존재하지 않는 게시글 입니다."));

        if(!post.getMember().getMemberId().equals(memberId)){
            throw new CustomException(HttpStatus.FORBIDDEN, "삭제 권한이 없습니다");
        }
        postRepository.delete(post);
    }

    // 페이지 네이션 : 보류
}
