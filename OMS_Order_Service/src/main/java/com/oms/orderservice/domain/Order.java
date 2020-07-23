package com.oms.orderservice.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString @NoArgsConstructor
@Entity
public class Order {
	@Id @GeneratedValue
	private long id;
	private String customerName, shippingAddress;
	private Date orderDate;
	@Transient
	private List<OrderItem> orderItems;
	private long total;

}
