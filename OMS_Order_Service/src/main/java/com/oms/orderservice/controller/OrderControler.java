package com.oms.orderservice.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.orderservice.domain.Order;
import com.oms.orderservice.domain.OrderItem;

import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
public class OrderControler {

	private OrderItemServiceProxy orderItemFeignClient;
	private OrderRepository repository;

	public OrderControler(OrderRepository repository,
			OrderItemServiceProxy orderItemServiceProxy) {
		this.repository = repository;
		this.orderItemFeignClient = orderItemServiceProxy;
	}
	@GetMapping(path="/orders")
	public List<Order> getAllOrders () {
		log.info("Before accessing DB order list");
		List<Order> items = repository.findAll();
		log.info("Found order items are:" + items);
		if(items.isEmpty() || null == items) {
			Order item = new Order();
			item.setCustomerName("DEFAULT Customer");
			item.setOrderDate(new Date());
			item.setTotal(0);
			repository.save(item);
		}
		return repository.findAll();
	}

	@GetMapping(path="/orderItems")
	public List<OrderItem> getAllOrderItems () {
		log.info("Before accessing DB order list");
		List<OrderItem> items = orderItemFeignClient.getAllOrderItems();
		log.info("Found order items are:" + items);
		return items ;
	}

	
	@PostMapping(path="/orders")
	public Order addOrderItem(@RequestBody Order item) {
		
		return repository.save(item);
	}
	
	@GetMapping(path="/orders/{id}")
	public Order findById(@PathVariable long id) throws OrderNotFoundException {
		Optional<Order> item = repository.findById(id);

		if (!item.isPresent())
			throw new OrderNotFoundException("id-" + id);
		return repository.findById(id).get();
	}
	
}
