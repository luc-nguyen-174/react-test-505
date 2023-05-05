package com.example.demo.service.carts.impl;

import com.example.demo.model.CartItems;
import com.example.demo.repo.ICartItemsRepository;
import com.example.demo.service.carts.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CartItemService implements ICartItemService {
    @Autowired
    private ICartItemsRepository cartItemsRepository;
    @Override
    public Iterable<CartItems> findAll() {
        return cartItemsRepository.findAll();
    }

    @Override
    public Optional<CartItems> findOne(Long id) {
        return cartItemsRepository.findById(id);
    }

    @Override
    public CartItems save(CartItems cartItems) {
        return cartItemsRepository.save(cartItems);
    }

    @Override
    public void remove(Long id) {
        cartItemsRepository.deleteById(id);
    }
}
