package com.oms.orderservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString @NoArgsConstructor
public class OrderItem {
	private long productCode;
	private int quantity;
	private String productName;
}
