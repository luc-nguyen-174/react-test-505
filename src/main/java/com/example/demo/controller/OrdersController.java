package com.example.demo.controller;

import com.example.demo.model.Orders;
import com.example.demo.service.orders.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        return new ResponseEntity<>((List<Orders>) orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Orders> createOrders(@RequestBody Orders orders) {
        return new ResponseEntity<>(orderService.save(orders), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long id, @RequestBody Orders orders) {
        Optional<Orders> order = orderService.findOne(id);
        if (order.isPresent()) {
            orders.setId(id);
            return new ResponseEntity<>(orderService.save(orders), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> deleteOrder(@PathVariable Long id) {
        Optional<Orders> orders = orderService.findOne(id);
        if (orders.isPresent()) {
            orderService.remove(id);
            return new ResponseEntity<>(orders.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> viewOrderDetail(@PathVariable Long id) {
        Optional<Orders> orders = orderService.findOne(id);
        return orders.map(order
                -> new ResponseEntity<>(order, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
