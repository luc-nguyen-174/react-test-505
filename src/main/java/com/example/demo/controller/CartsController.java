package com.example.demo.controller;

import com.example.demo.model.CartItems;
import com.example.demo.model.Carts;
import com.example.demo.service.carts.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/carts")
public class CartsController {
    @Autowired
    private ICartService cartService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Iterable<Carts>> getAllCarts() {
        List<Carts> carts = (List<Carts>) cartService.findAll();
        if (carts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Carts> createCarts(@RequestBody Carts carts) {
        return new ResponseEntity<>(cartService.save(carts), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Carts> updateCartsItems(@RequestBody Carts carts, @PathVariable Long id) {
        Optional<Carts> cartsOptional = cartService.findOne(id);
        if (cartsOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        carts.setId(id);
        return new ResponseEntity<>(cartService.save(carts), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Carts> deleteCarts(@PathVariable Long id) {
        Optional<Carts> cartsOptional = cartService.findOne(id);
        if (cartsOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cartService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carts> viewCartItems(@PathVariable Long id) {
        Optional<Carts> carts = cartService.findOne(id);
        if (carts.isPresent()) {
            return new ResponseEntity<>(carts.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
