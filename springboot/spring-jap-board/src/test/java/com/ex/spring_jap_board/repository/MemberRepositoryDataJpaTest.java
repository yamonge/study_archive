package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryDataJpaTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원 저장, 단건 조회, 삭제를 검증한다")
    void saveFindByIdAndDeleteTest() {
        Member member = createMember("user1@example.com", "홍길동");

        Member savedMember = memberRepository.saveAndFlush(member);

        Optional<Member> foundMember = memberRepository.findById(savedMember.getMemberId());
        assertTrue(foundMember.isPresent());
        assertEquals(savedMember.getMemberId(), foundMember.get().getMemberId());
        assertEquals("user1@example.com", foundMember.get().getMemberEmail());
        assertEquals("홍길동", foundMember.get().getMemberName());
        assertEquals("test1234", foundMember.get().getMemberPwd());

        memberRepository.deleteById(savedMember.getMemberId());
        memberRepository.flush();

        Optional<Member> deletedMember = memberRepository.findById(savedMember.getMemberId());
        assertTrue(deletedMember.isEmpty());
    }

    @Test
    @DisplayName("회원 조회 쿼리를 검증한다")
    void findQueryTest() {
        Member member1 = memberRepository.save(createMember("user1@example.com", "홍길동"));
        Member member2 = memberRepository.save(createMember("user2@example.com", "김철수"));
        memberRepository.flush();

        Optional<Member> foundByEmail = memberRepository.findByMemberEmail("user1@example.com");
        assertTrue(foundByEmail.isPresent());
        assertEquals(member1.getMemberId(), foundByEmail.get().getMemberId());
        assertEquals("user1@example.com", foundByEmail.get().getMemberEmail());

        Optional<Member> notFoundByEmail = memberRepository.findByMemberEmail("none@example.com");
        assertTrue(notFoundByEmail.isEmpty());

        List<Member> members = memberRepository.findAll();
        assertEquals(2, members.size());
        assertTrue(members.stream().anyMatch(member -> member.getMemberId().equals(member1.getMemberId())));
        assertTrue(members.stream().anyMatch(member -> member.getMemberId().equals(member2.getMemberId())));

        Optional<Member> foundByEmailAndPassword =
                memberRepository.findByMemberEmailAndMemberPwd("user2@example.com", "test1234");
        assertTrue(foundByEmailAndPassword.isPresent());
        assertEquals("김철수", foundByEmailAndPassword.get().getMemberName());

        Optional<Member> notFoundByWrongPassword =
                memberRepository.findByMemberEmailAndMemberPwd("user2@example.com", "wrong-password");
        assertTrue(notFoundByWrongPassword.isEmpty());

        assertTrue(memberRepository.existsByMemberEmail("user1@example.com"));
        assertFalse(memberRepository.existsByMemberEmail("none@example.com"));
    }

    @Test
    @DisplayName("필수 컬럼에 null 저장 시 예외가 발생한다")
    void nullableConstraintTest() {
        Member member = createMember("user1@example.com", "홍길동");
        member.setMemberPwd(null);

        assertThrows(DataIntegrityViolationException.class, () -> memberRepository.saveAndFlush(member));
    }

    @Test
    @DisplayName("중복 이메일 저장 시 예외가 발생한다")
    void uniqueConstraintTest() {
        memberRepository.saveAndFlush(createMember("duplicate@example.com", "홍길동"));

        Member duplicateMember = createMember("duplicate@example.com", "김철수");

        assertThrows(DataIntegrityViolationException.class, () -> memberRepository.saveAndFlush(duplicateMember));
    }

    private Member createMember(String email, String name) {
        Member member = new Member();
        member.setMemberEmail(email);
        member.setMemberPwd("test1234");
        member.setMemberName(name);
        member.setMemberRole("USER");
        return member;
    }
}
