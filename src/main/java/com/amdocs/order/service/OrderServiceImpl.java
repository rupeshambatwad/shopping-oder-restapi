package com.amdocs.order.service;

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
			order = orderRepository.save(orderDto.getOrder());
		} catch (Exception exc) {
			throw new Exception("exception occured" +exc.getMessage());
		}
		return mapToDto(order);
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
	
	private OrderDto mapToDto(Order order)
	{
		return modelMapper.map(order, OrderDto.class);	
	}
}
