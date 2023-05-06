package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import java.util.Collection;

@Entity
public class Carts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;
    @OneToMany(mappedBy = "cartsByCartId")
    @JsonIgnore
    private Collection<CartItems> cartItemsById;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userByUserId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carts carts = (Carts) o;

        if (id != carts.id) return false;
        if (userId != null ? !userId.equals(carts.userId) : carts.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    public Collection<CartItems> getCartItemsById() {
        return cartItemsById;
    }

    public void setCartItemsById(Collection<CartItems> cartItemsById) {
        this.cartItemsById = cartItemsById;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
