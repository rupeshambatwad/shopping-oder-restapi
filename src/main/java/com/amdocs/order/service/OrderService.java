package com.amdocs.order.service;

import java.util.List;

import com.amdocs.order.dto.OrderDto;

public interface OrderService {

	public OrderDto findOrderById(long id);
	public List<OrderDto> findAllOrders();
	public OrderDto createOrder(OrderDto orderDto);
	public void deleteOrder(long id);
	public OrderDto updateOrder(long id,OrderDto orderDto);
}
