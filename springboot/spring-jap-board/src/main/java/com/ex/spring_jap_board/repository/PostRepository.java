package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByMember_MemberId(Long memberId);
}
