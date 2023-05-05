package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private long price;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "picture")
    private String picture;
    @Basic
    @Column(name = "category_id", insertable = false, updatable = false)
    private long categoryId;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<CartItems> cartItemsById;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<OrderDetails> orderDetailsById;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category categoryByCategoryId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (price != product.price) return false;
        if (quantity != product.quantity) return false;
        if (categoryId != product.categoryId) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (picture != null ? !picture.equals(product.picture) : product.picture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (price ^ (price >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (int) (categoryId ^ (categoryId >>> 32));
        return result;
    }

    public Collection<CartItems> getCartItemsById() {
        return cartItemsById;
    }

    public void setCartItemsById(Collection<CartItems> cartItemsById) {
        this.cartItemsById = cartItemsById;
    }

    public Collection<OrderDetails> getOrderDetailsById() {
        return orderDetailsById;
    }

    public void setOrderDetailsById(Collection<OrderDetails> orderDetailsById) {
        this.orderDetailsById = orderDetailsById;
    }

    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
