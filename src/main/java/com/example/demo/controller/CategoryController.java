package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.Category.ICategoryervice;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    
    @GetMapping(value = {"", "/"})
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategoryItems(@RequestBody Category category, @PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findOne(id);
        if (categoryOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(id);
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findOne(id);
        if (categoryOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> viewCartItems(@PathVariable Long id) {
        Optional<Category> category = categoryService.findOne(id);
        if (category.isPresent()) {
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
