package com.example.demo.service.carts.impl;

import com.example.demo.model.Carts;
import com.example.demo.repo.ICartsRepository;
import com.example.demo.service.carts.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CartService implements ICartService {
    @Autowired
    private ICartsRepository cartsRepository;
    @Override
    public Iterable<Carts> findAll() {
        return cartsRepository.findAll();
    }

    @Override
    public Optional<Carts> findOne(Long id) {
        return cartsRepository.findById(id);
    }

    @Override
    public Carts save(Carts carts) {
        return cartsRepository.save(carts);
    }

    @Override
    public void remove(Long id) {
        cartsRepository.deleteById(id);
    }
}
