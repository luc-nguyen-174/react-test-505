package com.example.demo.controller;

import com.example.demo.model.CartItems;
import com.example.demo.service.carts.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("36")
public class CartItemsController {
    @Autowired
    private ICartItemService cartItemService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Iterable<CartItems>> showAllCartItems() {
        List<CartItems> carts = (List<CartItems>) cartItemService.findAll();
        if (carts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CartItems> createCartItems(@RequestBody CartItems cartItems) {
        return new ResponseEntity<>(cartItemService.save(cartItems), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CartItems> updateCartsItems(@RequestBody CartItems cartItems, @PathVariable Long id) {
        Optional<CartItems> cartItemsOptional = cartItemService.findOne(id);
        if (cartItemsOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cartItems.setId(id);
        return new ResponseEntity<>(cartItemService.save(cartItems), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CartItems> deleteCartItems(@PathVariable Long id) {
        Optional<CartItems> cartItemsOptional = cartItemService.findOne(id);
        if (cartItemsOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cartItemService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItems> viewCartItems(@PathVariable Long id) {
        Optional<CartItems> cartItems = cartItemService.findOne(id);
        if (cartItems.isPresent()) {
            return new ResponseEntity<>(cartItems.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
