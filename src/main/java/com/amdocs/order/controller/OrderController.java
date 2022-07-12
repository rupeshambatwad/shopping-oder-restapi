package com.amdocs.order.controller;

import com.amdocs.order.constants.orderConstants;
import com.amdocs.order.dto.OrderDto;
import com.amdocs.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("findById/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable long id) throws Exception {
        return new ResponseEntity<OrderDto>(orderService.findOrderById(id), HttpStatus.OK);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<OrderDto>> getAllOrders() throws Exception {
        return new ResponseEntity<List<OrderDto>>(orderService.findAllOrders(), HttpStatus.OK);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) throws Exception {
        return new ResponseEntity<OrderDto>(orderService.createOrder(orderDto), HttpStatus.CREATED);
    }

    @PostMapping("/createBulkOrder")
    public ResponseEntity<List<OrderDto>> createBulkOrder(@RequestBody List<OrderDto> orderDtos) throws Exception {
        return new ResponseEntity<List<OrderDto>>(orderService.createBulkOrder(orderDtos), HttpStatus.CREATED);
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable("orderId") long id) {
        log.info("inside delete api");
        try {

            boolean isExists = orderService.deleteOrder(id);

            if (isExists) {
                log.info(orderConstants.ORDER_DEL_SUCCESS);
                return orderConstants.ORDER_DEL_SUCCESS;
            } else {
                return orderConstants.ORDER_NOT_FOUND;
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            return orderConstants.ORDER_DEL_FAIL;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable long id, @RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(orderService.updateOrder(id, orderDto), HttpStatus.OK);
    }
}
