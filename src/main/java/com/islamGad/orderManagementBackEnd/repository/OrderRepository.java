package com.islamGad.orderManagementBackEnd.repository;

import com.islamGad.orderManagementBackEnd.models.OrderPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderPojo, Integer> {
}
