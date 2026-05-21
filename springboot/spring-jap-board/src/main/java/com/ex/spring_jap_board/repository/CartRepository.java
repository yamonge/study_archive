package com.ex.spring_jap_board.repository;

import com.ex.spring_jap_board.entity.Cart;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
