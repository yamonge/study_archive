package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.constant.ItemSellStatus;
import com.ex.spring_jap_board.entity.*;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@Slf4j
@TestPropertySource("classpath:application-test.properties")
class OrderItemRepositoryTest {
    // 의존성 주입 : 회원, 아이템, 주문서, 주문 목록, 카트, 카트아이템
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @PersistenceContext
    EntityManager em;

    // 멤버 생성 2개
    public Member createMember(String name, String email, String pwd){
        Member member = new Member();
        member.setMemberName(name);
        member.setMemberEmail(email);
        member.setMemberPwd(pwd);
        return member;
    }

    // 아이템 생성 3개
    public Item createItem(String name, int price, int stock, String detail){
        Item item = new Item();
        item.setItemName(name);
        item.setItemPrice(price);
        item.setItemStockNumber(stock);
        item.setItemDetail(detail);
        item.setItemSellStatus(ItemSellStatus.Y);
        return item;
    }

    // 카트 생성 2개
    public Cart createCart(String cartName, Member member){
        Cart cart = new Cart();
        cart.setCartName(cartName);
        cart.setMember(member);
        return cart;
    }

    // 카트 아이템 생성 4개
    public CartItem createCartItem(Cart cart, Item item, int quantity){
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setItem(item);
        cartItem.setQuantity(quantity);
        return cartItem;
    }

    // 주문서 생성 1개
    public Orders createOrders(Member member){
        Orders orders = new Orders();
        orders.setMember(member);
        return orders;
    }

    // 주문 아이템 생성 4개
    public OrderItem createOrderItem(Item item, Orders orders, int orderPrice, int quantity){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrders(orders);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setQuantity(quantity);
        return orderItem;
    }

    @Test
    @DisplayName("주문서 및 주문 아이템 테스트")
    public void Test1(){
        // 멤버 생성 2개
        Member member1 = createMember("홍길동", "hong@naver.com", "hong1234");
        Member member2 = createMember("김철수", "kim@naver.com", "kim1234");
        memberRepository.save(member1);
        memberRepository.save(member2);

        // 아이템 생성 3개
        Item item1 = createItem("상품1", 5000, 50, "상품상세설명1");
        Item item2 = createItem("상품2", 10000, 30, "상품상세설명2");
        Item item3 = createItem("상품3", 15000, 20, "상품상세설명3");
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        // 카트 생성 2개
        Cart cart1 = createCart("카트1", member1);
        Cart cart2 = createCart("카트2", member2);
        cartRepository.save(cart1);
        cartRepository.save(cart2);

        // 카트 아이템 생성 4개
        CartItem cartItem1 = createCartItem(cart1, item1, 1);
        CartItem cartItem2 = createCartItem(cart1, item2, 2);
        CartItem cartItem3 = createCartItem(cart2, item2, 3);
        CartItem cartItem4 = createCartItem(cart2, item3, 4);
        cartItemRepository.save(cartItem1);
        cartItemRepository.save(cartItem2);
        cartItemRepository.save(cartItem3);
        cartItemRepository.save(cartItem4);

        em.flush();
        em.clear();

        // 카트 아이템 1개 개수 수정
        CartItem fixCartItem1 = cartItemRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        fixCartItem1.setQuantity(fixCartItem1.getQuantity() + 1);
        // 주문서 생성 1개
        Orders orders = createOrders(member1);
        ordersRepository.save(orders);

        // 주문 아이템 생성 4개
        OrderItem orderItem1 = createOrderItem(item1, orders, 5000, 1);
        OrderItem orderItem2 = createOrderItem(item2, orders, 10000, 2);
        OrderItem orderItem3 = createOrderItem(item2, orders, 10000, 3);
        OrderItem orderItem4 = createOrderItem(item3, orders, 15000, 4);
        orderItemRepository.save(orderItem1);
        orderItemRepository.save(orderItem2);
        orderItemRepository.save(orderItem3);
        orderItemRepository.save(orderItem4);

        em.flush();
        em.clear();

        // 주문서에 저장된 주문 아이템 목록 가져오기
        List<OrderItem> itemList = orderItemRepository.findByOrdersOrdersId(1L);
        int index = 0;
        for(OrderItem item : itemList){
            log.error("orderItem{} : {}", index, item.getItem().getItemName());
            log.error("Item{} : {}", index, item1.getItemName());
            index++;
        }
    }
}
