package com.oms.orderservice.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.oms.orderservice.domain.OrderItem;

@FeignClient (name = "oms-order-item-service")
public interface OrderItemServiceProxy {

	@GetMapping(path="/orderItems")
	public List<OrderItem> getAllOrderItems ();

	@PostMapping(path="/orderItems")
	public OrderItem addOrderItem(@RequestBody OrderItem item);
	
	@GetMapping(path="/orderItems/{id}")
	public OrderItem findById(@PathVariable long id);
	
	
}
