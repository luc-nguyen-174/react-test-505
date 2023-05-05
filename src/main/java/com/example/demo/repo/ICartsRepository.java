package com.example.demo.repo;

import com.example.demo.model.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartsRepository extends JpaRepository<Carts, Long> {
}
