package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.constant.ItemSellStatus;
import com.ex.spring_jap_board.entity.Cart;
import com.ex.spring_jap_board.entity.CartItem;
import com.ex.spring_jap_board.entity.Item;
import com.ex.spring_jap_board.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
@TestPropertySource("classpath:application-test.properties")
class CartItemRepositoryTest {
    // 회원, 아이템, 카트, 카트 아이템 의존성 주입
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    EntityManager em;
    // 회원 생성 정보 메서드 구현 : 반환이 회원 엔티티
    public Member createMember(){
        Member member = new Member();
        member.setMemberName("홍길동");
        member.setMemberEmail("hong@naver.com");
        member.setMemberPwd("hong1234");
        member.setMemberRole("USER");
        return member;
    }
    // 상품 생성 메서드 구현 : 반환이 상품 엔티티
    public Item createItem(){
        Item item = new Item();
        item.setItemName("상품1");
        item.setItemDetail("상품상세설명1");
        item.setItemPrice(5000);
        item.setItemStockNumber(50);
        item.setItemSellStatus(ItemSellStatus.Y);
        return item;
    }
    // 장바구니 생성 및 장바구니 담기
    public Cart createCart(){
        Cart cart = new Cart();
        Member member = memberRepository.findById(1L)
                        .orElseThrow(EntityNotFoundException::new);
        cart.setCartName("카트1");
        cart.setMember(member);
        return cart;
    }
    // 1. 회원 생성 메서드 호출
    // 2. 상품 생성 메서드 호출
    // 3. 장바구니 생성
    // 4. 장바구니에 담을 상품 정보 생성
    // 5. 저장된 장바구니 상품 조회
    @Test
    @DisplayName("장바구니 생성 및 장바구니 담기 테스트")
    public void Test1(){
        Member member = createMember();
        memberRepository.save(member);
        Item item = createItem();
        itemRepository.save(item);

        em.flush();
        em.clear();

        Cart cart = createCart();
        cartRepository.save(cart);

        em.flush();
        em.clear();

        CartItem cartItem = new CartItem();
        cartItem.setCart(cartRepository.findById(1L).orElseThrow(EntityNotFoundException::new));
        cartItem.setItem(itemRepository.findById(1L).orElseThrow(EntityNotFoundException::new));
        cartItem.setQuantity(1);
        cartItemRepository.save(cartItem);

        em.flush();
        em.clear();

        CartItem cartItem2 = cartItemRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        assertEquals(cartItem2.getCart().getCartName(), cart.getCartName());
        log.error("cartItem : {}", cartItem2.getCart().getCartName());
        log.error("cart : {}", cart.getCartName());
        assertEquals(cartItem2.getItem().getItemName(), item.getItemName());
        log.error("cartItem : {}", cartItem2.getItem().getItemName());
        log.error("cart : {}", item.getItemName());

    }

}