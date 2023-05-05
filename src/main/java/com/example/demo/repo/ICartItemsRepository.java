package com.example.demo.repo;

import com.example.demo.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartItemsRepository extends JpaRepository<CartItems, Long> {
}
