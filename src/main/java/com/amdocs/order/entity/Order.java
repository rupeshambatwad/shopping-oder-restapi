package com.amdocs.order.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="ord_prod_pk" , referencedColumnName = "id")
	private List<Product> products;
}
