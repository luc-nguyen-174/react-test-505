package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details", schema = "demo-store", catalog = "")
public class OrderDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "oder_id", insertable = false, updatable = false)
    private long oderId;
    @Basic
    @Column(name = "product_id", insertable = false, updatable = false)
    private long productId;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "price")
    private long price;
    @ManyToOne
    @JoinColumn(name = "oder_id", referencedColumnName = "id", nullable = false)
    private Orders orderByOderId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product productByProductId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOderId() {
        return oderId;
    }

    public void setOderId(long oderId) {
        this.oderId = oderId;
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

        OrderDetails that = (OrderDetails) o;

        if (id != that.id) return false;
        if (oderId != that.oderId) return false;
        if (productId != that.productId) return false;
        if (quantity != that.quantity) return false;
        if (price != that.price) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (oderId ^ (oderId >>> 32));
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + quantity;
        result = 31 * result + (int) (price ^ (price >>> 32));
        return result;
    }

    public Orders getOrderByOderId() {
        return orderByOderId;
    }

    public void setOrderByOderId(Orders orderByOderId) {
        this.orderByOderId = orderByOderId;
    }

    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
