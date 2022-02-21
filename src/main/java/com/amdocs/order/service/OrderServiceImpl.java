package com.amdocs.order.service;

import com.amdocs.order.constants.orderConstants;
import com.amdocs.order.dto.OrderDto;
import com.amdocs.order.entity.Order;
import com.amdocs.order.exceptions.InvalidInputRequestException;
import com.amdocs.order.exceptions.ResourceNotFoundException;
import com.amdocs.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public OrderDto findOrderById(long id) {
        Order order = null;

        try {
            if (orderRepository.existsById(id)) {
                log.info(orderConstants.ORDER_EXISTS);
                order = orderRepository.findById(id).orElse(null);
            } else {
                log.info(orderConstants.ORDER_NOT_FOUND);
            }

        } catch (Exception exc) {
            log.error(exc.getMessage());
        }
        return mapToDto(order);
    }

    @Override
    public List<OrderDto> findAllOrders() {
        List<Order> orders = null;
        try {
            log.info(orderConstants.ORDER_EXISTS);
            orders = orderRepository.findAll();
        } catch (Exception exc) {
            log.error(exc.getMessage());
        }
        return mapToDtoList(orders);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) throws Exception {
        Order order;
        if (orderDto.getQty() <= 0
                || orderDto.getProducts() != null
                && orderDto.getProducts().size() < 1
                || orderDto.getPrice() <= 0) {
            throw new InvalidInputRequestException("101 :", " Create Order request ");
        }
        try {
            order = orderRepository.save(mapToEntity(orderDto));
        } catch (Exception exception) {
            throw new Exception("exception occured" + exception.getMessage());
        }
        return mapToDto(order);
    }

    @Override
    public List<OrderDto> createBulkOrder(List<OrderDto> orderDtos) throws Exception {
        List<Order> orders = new ArrayList<>();
        if (orderDtos.size() < 2) {
            throw new InvalidInputRequestException("102 :", " Create Bulk Order request");
        }
        try {
            orders.addAll(orderRepository.saveAll(mapToEntityList(orderDtos)));
        } catch (Exception exception) {
            throw new Exception("exception occured" + exception.getMessage());
        }
        return mapToDtoList(orders);
    }

    @Override
    public boolean deleteOrder(long id) {

        try {
            if (orderRepository.existsById(id)) {
                log.info(orderConstants.ORDER_EXISTS);
                orderRepository.deleteById(id);
                return true;

            } else {
                log.info(orderConstants.ORDER_NOT_FOUND);
                return false;

            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }

    }

    // update order by orderId
    @Override
    public OrderDto updateOrder(long id, OrderDto orderDto) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id :", id));
        order.setPrice(orderDto.getPrice());
        order.setDateTime(orderDto.getDateTime());
        order.setQty(orderDto.getQty());
        order.setProducts(orderDto.getProducts());
        Order updatedOrder = orderRepository.save(order);

        return mapToDto(updatedOrder);
    }

    private Order mapToEntity(OrderDto dto) {
        Order order = new Order();
        order = modelMapper.map(dto, Order.class);
        return order;
    }

    private List<Order> mapToEntityList(List<OrderDto> orderDtos) {
        List<Order> orders = new ArrayList<>();
        for (OrderDto dto : orderDtos)
            orders.add(modelMapper.map(dto, Order.class));
        return orders;
    }

    private OrderDto mapToDto(Order order) {
        return modelMapper.map(order, OrderDto.class);
    }

    private List<OrderDto> mapToDtoList(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders)
            orderDtos.add(modelMapper.map(order, OrderDto.class));
        return orderDtos;
    }
}
