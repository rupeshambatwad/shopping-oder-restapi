package com.amdocs.order.dto;

import java.util.Date;
import java.util.List;

import com.amdocs.order.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	private long id;
	private long price;
	private int qty;
	private Date dateTime;
	private List<Product> product;

}
