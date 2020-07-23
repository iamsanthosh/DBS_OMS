package com.oms.orderitemservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oms.orderitemservice.domain.OrderItem;
import com.oms.orderitemservice.exception.OrderItemNotFoundException;
import com.oms.orderitemservice.repository.OrderItemRepository;
import com.sun.tools.sjavac.Log;

import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
public class OrderItemControler {

	private OrderItemRepository repository;

	public OrderItemControler(OrderItemRepository repository) {
		this.repository = repository;
	}
	@GetMapping(path="/orderItems")
	public List<OrderItem> getAllOrderItems () {
		log.info("Before accessing DB order list");
		List<OrderItem> items = repository.findAll();
		log.info("Found order items are:" + items);
		if(items.isEmpty() || null == items) {
			OrderItem item = new OrderItem();
			item.setProductName("DEFAULT Product");
			item.setQuantity(1);
			repository.save(item);
		}
		return repository.findAll();
	}
	
	@PostMapping(path="/orderItems")
	public OrderItem addOrderItem(@RequestBody OrderItem item) {
		
		return repository.save(item);
	}
	
	@GetMapping(path="/orderItems/{id}")
	public OrderItem findById(@PathVariable long id) throws OrderItemNotFoundException {
		Optional<OrderItem> item = repository.findById(id);

		if (!item.isPresent())
			throw new OrderItemNotFoundException("id-" + id);

		return repository.findById(id).get();
	}
	
}
