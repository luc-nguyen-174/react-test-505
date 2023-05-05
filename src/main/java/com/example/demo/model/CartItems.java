package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items", schema = "demo-store", catalog = "")
public class CartItems {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "cart_id")
    private long cartId;
    @Basic
    @Column(name = "product_id")
    private long productId;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "price")
    private long price;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    private Carts cartsByCartId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product productByProductId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
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
