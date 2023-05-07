package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repo.ICategoryRepository;
import com.example.demo.service.category.ICategoryService;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    Environment env;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>((List<Product>) productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> uploadFile(MultipartHttpServletRequest request) {
        String name = request.getParameter("name");
        Long price = Long.parseLong(request.getParameter("price"));
        String des = request.getParameter("description");
        Long quantity = Long.parseLong(request.getParameter("quantity"));
        Long categoryId = Long.parseLong(request.getParameter("categoryId"));



        Product product = new Product(name,price,des,quantity);
        product.setCategoryId(categoryId);
        MultipartFile fileMultipart = request.getFile("picture");
        String image = fileMultipart.getOriginalFilename();

        String fileUpload = env.getProperty("upload.path").toString();
        try {
            fileMultipart.transferTo(new File(fileUpload + image));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Category category = categoryRepository.getCategoriesById(categoryId);
        product.setCategoryByCategoryId(category);


        product.setPicture(image);
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody Product product ){
        Optional<Product> productOptional = productService.findOne(id);
        if(productOptional.isPresent()){
            product.setId(id);
            return ResponseEntity.ok(productService.save(product));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        Optional<Product> productOptional = productService.findOne(id);
        if(productOptional.isPresent()){
            productService.remove(id);
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> viewProductDetail(@PathVariable long id) {
        Optional<Product> productOptional = productService.findOne(id);
        return productOptional.map(product
                -> new ResponseEntity<>(product, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
