package com.amdocs.order.service;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.order.dto.OrderDto;
import com.amdocs.order.entity.Order;
import com.amdocs.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public OrderDto findOrderById(long id) {
		
		return null;
	} 

	@Override
	public List<OrderDto> findAllOrders() {
		
		return null;
	}

	@Override
	public OrderDto createOrder(OrderDto orderDto) throws Exception {
		Order order;
		try {
			order = orderRepository.save(mapToEntity(orderDto));
		} catch (Exception exc) {
			throw new Exception("exception occured" +exc.getMessage());
		}
		return mapToDto(order);
	}

	@Override
	public List<OrderDto> createBulkOrder(List<OrderDto> orderDtos) throws Exception {
		List<Order> orders = new ArrayList<>();
		try {
			orders.addAll(orderRepository.saveAll(mapToEntityList(orderDtos)));
		} catch (Exception exc) {
			throw new Exception("exception occured" +exc.getMessage());
		}
		return mapToDtoList(orders);
	}

	@Override
	public void deleteOrder(long id) {
		
	}

	@Override
	public OrderDto updateOrder(long id,OrderDto orderDto) {

		
		return null;
	}

	private Order mapToEntity(OrderDto dto)
	{
		Order order=new Order();
		order=modelMapper.map(dto, Order.class);		
		return order;
	}

	private List<Order> mapToEntityList(List<OrderDto> orderDtos)
	{
		List<Order> orders=new ArrayList<>();
		for(OrderDto dto : orderDtos)
			orders.add(modelMapper.map(dto, Order.class));
		return orders;
	}
	
	private OrderDto mapToDto(Order order)
	{
		return modelMapper.map(order, OrderDto.class);	
	}
	private List<OrderDto> mapToDtoList(List<Order> orders)
	{
		List<OrderDto> orderDtos=new ArrayList<>();
		for(Order order : orders)
		orderDtos.add(modelMapper.map(order, OrderDto.class));
		return orderDtos;
	}
}
