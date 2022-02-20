package com.amdocs.order.dto;

import com.amdocs.order.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {

    private long id;
    private long price;
    private int qty;
    private Date dateTime;
    private List<Product> products;

}
