package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.entity.Cart;
import com.ex.spring_jap_board.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
@TestPropertySource("classpath:application-test.properties")
@Transactional
class CartRepositoryTest {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext // JPA의 EntityManager 주입
    EntityManager em;

    //회원 엔티티 생성
    public Member createMember(){
        Member member = new Member();
        member.setMemberName("홍길동");
        member.setMemberEmail("example@naver.com");
        member.setMemberPwd("test1234");
        return member;
    }

    @Test
    @DisplayName("장바구니 회원 매핑 조회 테스트")
    public void findCartAndMemberTest(){
        Cart cart = new Cart();
        Member member = createMember();
        memberRepository.save(member);
        cart.setMember(member);
        cart.setCartName("테스트 장바구니");
        cartRepository.save(cart);

        em.flush();
        em.clear();

        Cart saveCart = cartRepository.findById(cart.getId())
                .orElseThrow(EntityNotFoundException::new);

        // 저장된 장바구니 엔티티의 회운 이름과 생성한 회원 엔티티의
        assertEquals(saveCart.getMember().getMemberName(), member.getMemberName());
        log.error("saveCart : {}", saveCart.getMember().getMemberName());
        log.error("member: {}", member.getMemberName());
    }
}