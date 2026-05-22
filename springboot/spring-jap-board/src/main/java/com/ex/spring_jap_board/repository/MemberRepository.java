package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberEmail(String memberEmail);
    boolean existsByMemberEmail(String memberEmail);
    Optional<Member> findByMemberEmailAndMemberPwd(String memberEmail, String memberPwd);
    Optional<Member> findByRefreshToken(String refreshToken);
}
