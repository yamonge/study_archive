package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.constant.ItemSellStatus;
import com.ex.spring_jap_board.entity.Item;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    // 상품 입력 테스트
    @Test
    @DisplayName("상품저장 테스트")
    public void saveTest(String itemName, String itemDetail){
        Item item = new Item();
        item.setItemName(itemName);
        item.setItemPrice(3000);
        item.setItemDetail(itemDetail);
        item.setItemSellStatus(ItemSellStatus.Y);
        item.setItemStockNumber(100);
        item.setItemRegTime(LocalDateTime.now());
        item.setItemUpdateTime(LocalDateTime.now());
        itemRepository.save(item);
    }

    // 상품 조회 테스트
    @Test
    @DisplayName("상품 조회 테스트")
    public void findByItemNameTest(){
        saveTest("테스트 상품", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemName("테스트 상품");
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    // 문제 1. 상품명이 "테스트 상품5"인 상품을 조회하는 쿼리 메서드를 작성하고 테스트하시오.
    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNameTest2(){
        saveTest("테스트 상품5", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemName("테스트 상품5");
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("상품명 및 상품설명 테스트")
    public void findByItemNameOrItemDetailTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemNameOrItemDetail("테스트 상품1", "테스트 상품 상세 설명2");
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("상품 가격 테스트")
    public void findByItemPriceLessThanTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemPriceLessThan(50000);
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("상품 가격 테스트")
    public void findByItemPriceLessThanOrderByItemPriceDescTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemPriceLessThanOrderByItemPriceDesc(50000);
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("상품 가격 테스트")
    public void findByItemDetailLikeTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemDetailLike("%상세 설명1%");
        if(items.isEmpty()){
            System.out.println("결과없음");
            return;
        }
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("상품 이넘 테스트")
    public void findByItemSellStatusTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemSellStatus(ItemSellStatus.Y);
        if(items.isEmpty()){
            fail("조회된 상품 데이터가 없어 테스트를 실패 처리합니다.");
        }
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("상품 가격 범위 테스트")
    public void findByItemPriceBetweenTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemPriceBetween(30000, 70000);
        if(items.isEmpty()){
            fail("조회된 상품 데이터가 없어 테스트를 실패 처리합니다.");
        }
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("상품 상태 개수 테스트")
    public void countByItemSellStatusTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        Long countY = itemRepository.countByItemSellStatus(ItemSellStatus.Y);
        Long countN = itemRepository.countByItemSellStatus(ItemSellStatus.N);
        System.out.println("결과: " + countY);
        System.out.println("결과: " + countN);
    }

    @Test
    @DisplayName("상품 존재 여부 테스트")
    public void existByItemNameTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        boolean rst1 = itemRepository.existsByItemName("테스트 상품1");
        boolean rst2 = itemRepository.existsByItemName("없는 상품");
        System.out.println("결과: " + rst1);
        System.out.println("결과: " + rst2);
    }

    @Test
    @DisplayName("상품 재고 조회 테스트")
    public void findByItemStockNumberLessThanOrderByItemStockNumberAscTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemStockNumberLessThanOrderByItemStockNumberAsc(50);
        if(items.isEmpty()){
            fail("조회된 상품 데이터가 없어 테스트를 실패 처리합니다.");
        }
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("JPQL 문제1")
    public void findByItemPriceJPQLTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemPriceJPQL(50000);
        if(items.isEmpty()){
            fail("조회된 상품 데이터가 없어 테스트를 실패 처리합니다.");
        }
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("JPQL 문제2")
    public void findByItemStatusAndStockTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByItemStatusAndStock(ItemSellStatus.Y, 60);
        if(items.isEmpty()){
            fail("조회된 상품 데이터가 없어 테스트를 실패 처리합니다.");
        }
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("NATIVE 문제1")
    public void findByLikeNameNativeTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByLikeNameNative("상세 설명1");
        if(items.isEmpty()){
            fail("조회된 상품 데이터가 없어 테스트를 실패 처리합니다.");
        }
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }

    @Test
    @DisplayName("NATIVE 문제2")
    public void findByBetweenPriceTest(){
        saveTest("테스트 상품1", "테스트 상품 상세 설명2");
        List<Item> items = itemRepository.findByBetweenPrice(30000, 70000);
        if(items.isEmpty()){
            fail("조회된 상품 데이터가 없어 테스트를 실패 처리합니다.");
        }
        for(Item item : items){
            System.out.println("결과: " + item);
        }
    }
}