package com.amdocs.order.service;

import java.util.List;

import com.amdocs.order.dto.OrderDto;
import com.amdocs.order.entity.Order;

public interface OrderService {

	public OrderDto findOrderById(long id);
	public List<OrderDto> findAllOrders();
	public OrderDto createOrder(OrderDto orderDto) throws Exception;
	public List<OrderDto> createBulkOrder(List<OrderDto> orderDtos) throws Exception;
	public boolean deleteOrder(long id);
	public OrderDto updateOrder(long id,OrderDto orderDto);
}
