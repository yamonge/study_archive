package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.entity.CartItem;
import com.ex.spring_jap_board.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
