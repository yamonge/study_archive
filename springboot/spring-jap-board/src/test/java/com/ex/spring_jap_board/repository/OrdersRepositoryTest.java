package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.constant.ItemSellStatus;
import com.ex.spring_jap_board.entity.Item;
import com.ex.spring_jap_board.entity.OrderItem;
import com.ex.spring_jap_board.entity.Orders;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
@TestPropertySource("classpath:application-test.properties")
class OrdersRepositoryTest {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @PersistenceContext
    EntityManager em;

    public Item createItem(){
        Item item = new Item();
        item.setItemName("테스트 상품");
        item.setItemPrice(10000);
        item.setItemDetail("상세설명");
        item.setItemSellStatus(ItemSellStatus.Y);
        item.setItemStockNumber(100);
        return item;
    }

    @Test
    @DisplayName("영속성 전의 테스트")
    public void casecadeTest(){
        Orders orders = new Orders();
        for(int i = 0; i < 3; i++){
            Item item = createItem();
            itemRepository.save(item);
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setQuantity(10);
            orderItem.setOrders(orders);
            orderItem.setOrderPrice(1000);
            orders.getOrderItemList().add(orderItem);
        }

        ordersRepository.saveAndFlush(orders);
        em.clear();
        Orders findOrders = ordersRepository.findById(orders.getOrdersId())
                .orElseThrow(EntityExistsException::new);
        log.error("findOrder: {}", findOrders.getOrderItemList().size());
    }
}