package com.amdocs.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Orders")
@Entity
public class Order {
    @Id
    @GeneratedValue
    private long id;
    private long price;
    private int qty;
    private Date dateTime;
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_prod_pk", referencedColumnName = "id")
    private List<Product> products;
}
