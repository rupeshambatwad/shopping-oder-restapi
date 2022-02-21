package com.amdocs.order.shoppingoderrestapi;

import com.amdocs.order.dto.OrderDto;
import com.amdocs.order.entity.Order;
import com.amdocs.order.entity.Product;
import com.amdocs.order.repository.OrderRepository;
import com.amdocs.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.anyLong;

@SpringBootTest

public class DeleteOrderTest {
    @Autowired
    OrderService orderService;
    @Mock
    OrderRepository orderRepository;

    @Test
    void DeleteOrder() throws Exception {

        List<Product> prodList = new ArrayList<>();
        Product prod = new Product();
        prod.setProdId(6);
        prod.setProdPrice(100);
        prod.setProdName("Amdocs");
        prodList.add(prod);

        Order order = new Order();
        order.setDateTime(new Date());
        order.setQty(15);
        order.setProducts(prodList);
        order.setPrice(600);
        order.setId(1000);

        OrderDto dto = new OrderDto();
        dto.setDateTime(new Date());
        dto.setPrice(1500);
        dto.setId(6666);
        dto.setQty(24);
        dto.setProducts(prodList);

        given(orderRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        orderService.deleteOrder(order.getId());

    }

}





