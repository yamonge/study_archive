package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.constant.ItemSellStatus;
import com.ex.spring_jap_board.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // 기본 CRUD는 포함
    // save(entity)
    // findbyId()
    // findAll()
    // delete(id)
    // count()
    // ...등등
    // 문제 1. 상품명이 "테스트 상품5"인 상품을 조회하는 쿼리 메서드를 작성하고 테스트하시오.
    List<Item> findByItemName(String itemName);
    // 문제 2. 상품명이 "테스트 상품1" 이거나 상세설명이 "테스트 상품 상세 설명2"인 상품을 조회하는 쿼리 메서드를 작성하고 테스트하시오.
    List<Item> findByItemNameOrItemDetail(String itemName, String itemDetail);
    // 문제 3. 가격이 50000원 미만인 상품을 조회하는 쿼리 메서드를 작성하고 테스트하시오.
    List<Item> findByItemPriceLessThan(int itemPrice);
    // 문제 4. 가격이 50000원 미만인 상품을 가격 내림차순으로 조회하는 쿼리 메서드를 작성하고 테스트하시오.
    List<Item> findByItemPriceLessThanOrderByItemPriceDesc(int itemPrice);
    // 문제 5. 상세설명에 "상세 설명1"이라는 키워드가 포함된 상품을 조회하는 쿼리 메서드를 작성하고 테스트하시오.

    // 문제 6. 판매 상태가 SELL인 상품 목록과 SOLD_OUT인 상품 목록을 각각 조회하는 쿼리 메서드를 작성하고 테스트하시오.
    List<Item> findByItemSellStatus(ItemSellStatus itemSellStatus);
    // 문제 7. 가격이 30000원 이상 70000원 이하인 상품을 조회하는 쿼리 메서드를 작성하고 테스트하시오.
    List<Item> findByItemPriceBetween(int minItemPrice, int maxItemPrice);
    // 문제 8. 판매 상태가 SELL인 상품의 개수와 SOLD_OUT인 상품의 개수를 각각 조회하는 쿼리 메서드를 작성하고 테스트하시오.
    Long countByItemSellStatus(ItemSellStatus itemSellStatus);
    // 문제 9. 상품명 "테스트 상품1"이 존재하는지 여부와 "없는 상품"이 존재하는지 여부를 조회하는 쿼리 메서드를 작성하고 테스트하시오.
    boolean existsByItemName(String itemName);
    // 문제 10. 재고가 50 미만인 상품을 재고 오름차순으로 조회하는 쿼리 메서드를 작성하고 테스트하시오.
    List<Item> findByItemStockNumberLessThanOrderByItemStockNumberAsc(int itemStockNumber);

    // JPQL : JPA Query Language, 객체 지향 쿼리
    // -SQL문법과 비슷하지만 테이블명 대신 클래스명, 컬럼명 대신 필드명을 사용
    // Like 검색 Native Query를 이용
    @Query("SELECT i FROM Item i WHERE i.itemDetail LIKE %:itemDetail% ORDER BY i.itemPrice DESC")
    List<Item> findByItemDetailLike(String itemDetail);

    @Query(value = "SELECT * FROM item WHERE item_detail Like %:itemDetail% ORDER BY item_price DESC", nativeQuery = true)
    List<Item> findByItemDetailLikeNative(String itemDetail);

    // ## JPQL 문제
    // 문제 1. 가격이 50000원 미만인 상품을 가격 내림차순으로 조회하는 JPQL 쿼리를 작성하고 테스트하시오.
    // 단, 테이블명 대신 클래스명 Item, 컬럼명 대신 필드명 price를 사용할 것.
    @Query("SELECT i FROM Item i WHERE i.itemPrice < :itemPrice ORDER BY i.itemPrice DESC")
    List<Item> findByItemPriceJPQL(int itemPrice);
    // 문제 2. 판매 상태가 SELL이면서 재고가 60 미만인 상품을 조회하는 JPQL 쿼리를 작성하고 테스트하시오.
    // 단, @Param을 사용하여 파라미터를 바인딩할 것.
    @Query("SELECT i FROM Item i WHERE i.itemSellStatus = :itemSellStatus AND i.itemStockNumber < :itemStockNumber")
    List<Item> findByItemStatusAndStock(ItemSellStatus itemSellStatus, int itemStockNumber);

    // ## Native 쿼리 문제
    // 문제 3. 상세설명(item_detail)에 "상세 설명1" 키워드가 포함된 상품을 조회하는 Native 쿼리를 작성하고 테스트하시오.
    // 단, nativeQuery = true 옵션과 SQL의 LIKE를 사용할 것.
    @Query(value = "SELECT * FROM item WHERE item_detail LIKE %:itemDetail%", nativeQuery = true)
    List<Item> findByLikeNameNative(String itemDetail);
    // 문제 4. 가격이 30000원 이상 70000원 이하인 상품을 가격 오름차순으로 조회하는 Native 쿼리를 작성하고 테스트하시오.
    // 단, SQL의 BETWEEN을 사용할 것.
    @Query(value = "SELECT * FROM item WHERE item_price BETWEEN :itemPrice1 AND :itemPrice2 ORDER BY item_price ASC", nativeQuery = true)
    List<Item> findByBetweenPrice(int itemPrice1, int itemPrice2);


}
