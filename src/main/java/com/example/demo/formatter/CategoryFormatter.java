package com.example.demo.formatter;

import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;
@Component
public class CategoryFormatter implements Formatter<Category> {

    @Autowired
    private ICategoryService categoryService;

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> authorOptional = categoryService.findOne(Long.parseLong(text));
        return authorOptional.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + ", " +object.getCategoryName() + "]";
    }
}
