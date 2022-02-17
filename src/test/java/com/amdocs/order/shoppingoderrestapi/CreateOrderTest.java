package com.amdocs.order.shoppingoderrestapi;

import com.amdocs.order.controller.OrderController;
import com.amdocs.order.dto.OrderDto;
import com.amdocs.order.entity.Order;
import com.amdocs.order.entity.Product;
import com.amdocs.order.repository.OrderRepository;
import com.amdocs.order.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreateOrderTest {

    @Autowired
    OrderService orderService;
    @Mock
    OrderRepository orderRepository;

    @Test
    void testCreateOrder() throws Exception {

        //Dummy Product list
        List<Product> prodList =  new ArrayList<>();
        Product prod =  new Product();
        prod.setProdId(123);
        prod.setProdPrice(1234);
        prod.setProdName("Harman");
        prodList.add(prod);

        //dummy Order POJO
        Order order = new Order();
        order.setDateTime(new Date());
        order.setQty(13);
        order.setProducts(prodList);
        order.setPrice(12);
        order.setId(12);

        //Dummy OrderDto POJO
        OrderDto dto = new OrderDto();
        dto.setDateTime(new Date());
        dto.setPrice(13);
        dto.setId(123);
        dto.setQty(3);
        dto.setProducts(prodList);

        //mocking the database call
        when(orderRepository.save(any())).thenReturn(order);
        OrderDto o = orderService.createOrder(dto);
        Assertions.assertEquals(true,o!=null);
        Assertions.assertEquals(true,o.getPrice()>0);
        Assertions.assertEquals(true,o.getQty()>0);
        Assertions.assertEquals(true,o.getProducts().size()>0);
    }
}
