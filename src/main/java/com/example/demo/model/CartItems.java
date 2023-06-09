package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "cart_items", schema = "demo-store", catalog = "")
public class CartItems {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "cart_id", insertable = false, updatable = false)
    private Long cartId;
    @Basic
    @Column(name = "product_id", insertable = false, updatable = false)
    private Long productId;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "price")
    private Long price;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    private Carts cartsByCartId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product productByProductId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItems cartItems = (CartItems) o;

        if (id != cartItems.id) return false;
        if (cartId != cartItems.cartId) return false;
        if (productId != cartItems.productId) return false;
        if (quantity != cartItems.quantity) return false;
        if (price != cartItems.price) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (cartId ^ (cartId >>> 32));
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + quantity;
        result = 31 * result + (int) (price ^ (price >>> 32));
        return result;
    }

    public Carts getCartsByCartId() {
        return cartsByCartId;
    }

    public void setCartsByCartId(Carts cartsByCartId) {
        this.cartsByCartId = cartsByCartId;
    }

    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
