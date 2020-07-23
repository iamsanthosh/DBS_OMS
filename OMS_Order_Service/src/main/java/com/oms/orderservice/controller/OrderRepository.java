package com.oms.orderservice.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.orderservice.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
