package com.fruitshop.domain;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseOrder {

	private Long id;
	private List<Fruit> fruits;
	private BigDecimal totalPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Fruit> getFruits() {
		return fruits;
	}

	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}

	public BigDecimal getTotalPrice() {
		if (getFruits() != null && !getFruits().isEmpty()) {
			totalPrice = new BigDecimal(0);
			for(Fruit fruit: getFruits()) {
				BigDecimal total = totalPrice.add(fruit.getPrice().multiply(new BigDecimal(fruit.getQuantity())));
				totalPrice = total;
			}
		}
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", fruits=" + fruits + ", totalPrice=" + totalPrice + "]";
	}

}
