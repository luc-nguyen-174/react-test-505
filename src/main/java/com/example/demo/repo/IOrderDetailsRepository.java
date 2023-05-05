package com.example.demo.repo;

import com.example.demo.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
