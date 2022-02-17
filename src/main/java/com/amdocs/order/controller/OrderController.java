package com.amdocs.order.controller;

import java.util.List;

import com.amdocs.order.constants.orderConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amdocs.order.dto.OrderDto;
import com.amdocs.order.service.OrderService;

@Slf4j
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

	@DeleteMapping("/{orderId}")
	public String deleteOrder(@PathVariable("orderId")long id) {
        log.info("inside delete api");
		try {

		boolean isExists = orderService.deleteOrder(id);

		if(isExists){
			log.info(orderConstants.ORDER_DEL_SUCCESS);
			return orderConstants.ORDER_DEL_SUCCESS;
		}else{
			return orderConstants.ORDER_NOT_FOUND;
		}

		} catch (Exception e) {
			log.error(e.getMessage());
			return orderConstants.ORDER_DEL_FAIL;
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderDto> updateOrder(@PathVariable long id,@RequestBody OrderDto orderDto)
	{
		return new ResponseEntity<>(orderService.updateOrder(id, orderDto), HttpStatus.OK);
	}
}
