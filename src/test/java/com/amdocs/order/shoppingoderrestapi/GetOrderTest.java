package com.amdocs.order.shoppingoderrestapi;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amdocs.order.dto.OrderDto;
import com.amdocs.order.entity.Order;
import com.amdocs.order.entity.Product;
import com.amdocs.order.repository.OrderRepository;
import com.amdocs.order.service.OrderService;

@SpringBootTest
public class GetOrderTest {
	 @Autowired
	    OrderService orderService;
	    @Mock
	    OrderRepository orderRepository;
	 
	    
	    @Test
	    void testFindAllOrders() {
	        //Dummy Product list
	        List<Product> prodList =  new ArrayList<>();
	        Product prod =  new Product();
	        prod.setProdId(123);
	        prod.setProdPrice(1234);
	        prod.setProdName("Harman");
	        
	        Product prod1 =  new Product();
	        prod1.setProdId(456);
	        prod1.setProdPrice(234);
	        prod1.setProdName("Harman1");
	        prodList.add(prod);
	        prodList.add(prod1);

	        //dummy Order POJO
	        Order order = new Order();
	        order.setDateTime(new Date());
	        order.setQty(13);
	        order.setProducts(prodList);
	        order.setPrice(12);
	        order.setId(12);
	        
	        List<Order> orders=new ArrayList<Order>();
	        orders.add(order);

	        //Dummy OrderDto POJO
	        OrderDto dto = new OrderDto();
	        dto.setDateTime(new Date());
	        dto.setPrice(13);
	        dto.setId(123);
	        dto.setQty(3);
	        dto.setProducts(prodList);
	    	
	      //mocking the database call
	        when(orderRepository.findAll()).thenReturn(orders);
	        Assertions.assertEquals(12,orders.get(0).getPrice());
	        Assertions.assertEquals("Harman",orders.get(0).getProducts().get(0).getProdName());
	        Assertions.assertEquals("Harman1",orders.get(0).getProducts().get(1).getProdName());
	        
	    }
}