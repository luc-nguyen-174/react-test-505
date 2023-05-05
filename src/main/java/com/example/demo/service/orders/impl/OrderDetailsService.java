package com.example.demo.service.orders.impl;

import com.example.demo.model.OrderDetails;
import com.example.demo.repo.IOrderDetailsRepository;
import com.example.demo.service.orders.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailsService implements IOrderDetailService {

    @Autowired
    private IOrderDetailsRepository orderDetailsRepository;

    @Override
    public Iterable<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public Optional<OrderDetails> findOne(Long id) {
        return orderDetailsRepository.findById(id);
    }

    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public void remove(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
