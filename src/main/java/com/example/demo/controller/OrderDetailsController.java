package com.example.demo.controller;

import com.example.demo.model.OrderDetails;
import com.example.demo.service.orders.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/orderDetails")
public class OrderDetailsController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
        return new ResponseEntity<>((List<OrderDetails>) orderDetailService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDetails> createOrderDetails(@RequestBody OrderDetails orders) {
        return new ResponseEntity<>(orderDetailService.save(orders), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetails> updateOrderDetails(@PathVariable long id, @RequestBody OrderDetails orders) {
        Optional<OrderDetails> order = orderDetailService.findOne(id);
        if (order.isPresent()) {
            orders.setId(id);
            return new ResponseEntity<>(orderDetailService.save(orders), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDetails> deleteOrderDetails(@PathVariable long id) {
        Optional<OrderDetails> orders = orderDetailService.findOne(id);
        if (orders.isPresent()) {
            orderDetailService.remove(id);
            return new ResponseEntity<>(orders.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> viewOrderOrderDetails(@PathVariable long id) {
        Optional<OrderDetails> orders = orderDetailService.findOne(id);
        return orders.map(order
                -> new ResponseEntity<>(order, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
