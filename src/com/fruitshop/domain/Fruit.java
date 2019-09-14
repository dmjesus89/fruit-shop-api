package com.fruitshop.domain;

import java.math.BigDecimal;

/**
 * Model responsable for DTO Fruit
 * 
 * @author oliveira
 *
 */
public class Fruit {

	private Long id;
	private String name;
	private BigDecimal price;
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
