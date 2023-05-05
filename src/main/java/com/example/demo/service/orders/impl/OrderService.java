package com.example.demo.service.orders.impl;

import com.example.demo.model.Orders;
import com.example.demo.repo.IOrderRepository;
import com.example.demo.service.orders.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Iterable<Orders> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Orders> findOne(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Orders save(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public void remove(Long id) {
        orderRepository.deleteById(id);
    }
}
