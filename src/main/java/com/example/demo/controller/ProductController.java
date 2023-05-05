package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>((List<Product>) productService.findAll(), HttpStatus.OK)
    }
}
