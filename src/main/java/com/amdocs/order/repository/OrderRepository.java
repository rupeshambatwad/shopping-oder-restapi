package com.amdocs.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
