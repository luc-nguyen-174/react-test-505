package com.example.demo.model.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Long price;
    private String description;
    private int quantity;
    private String picture;
    private Long categoryId;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Long price, String description, int quantity, String picture, Long categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.picture = picture;
        this.categoryId = categoryId;
    }
}
