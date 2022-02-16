package com.amdocs.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.order.dto.OrderDto;
import com.amdocs.order.service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@GetMapping("/{id}")
	public OrderDto getOrderById(@PathVariable long id)
	{
		return null;
	}
	public List<OrderDto> getAllOrders()
	{
		return null;
	}

	@PostMapping("/createOrder")
	public OrderDto createOrder(@RequestBody OrderDto orderDto) throws Exception {
		return orderService.createOrder(orderDto);
	}

	@PostMapping("/createBulkOrder")
	public List<OrderDto> createOrder(@RequestBody List<OrderDto> orderDtos) throws Exception {
		return orderService.createBulkOrder(orderDtos);
	}

	public void deleteOrder(long id)
	{
		
	}
	public OrderDto updateOrder(long id,OrderDto orderDto)
	{
		return null;
	}
}
