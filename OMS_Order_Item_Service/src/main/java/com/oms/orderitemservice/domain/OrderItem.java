package com.oms.orderitemservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString @NoArgsConstructor
@Entity
public class OrderItem {
	@Id @GeneratedValue
	private long productCode;
	//@Size(min=1, message="Minmum atleast 1 quantity")
	private int quantity;
	//@NotBlank @Size(min=1, message="Minmum atleast 2 characters for productName") 
	private String productName;
}
