package com.fruitshop.service;

import java.util.List;

import com.fruitshop.controller.FruitController;
import com.fruitshop.domain.Fruit;
import com.fruitshop.domain.PurchaseOrder;
import com.fruitshop.repository.PurchaseOrderRepository;

public class PurchaseOrderService {

	public static void buyFruits(PurchaseOrder purchaseOrder) {
		
		for (Fruit fruit : purchaseOrder.getFruits()) {
			Fruit fruitToSale = new Fruit();
			fruitToSale.setId(fruit.getId());
			fruitToSale.setName(fruit.getName());
			fruitToSale.setPrice(fruit.getPrice());
			fruitToSale.setQuantity(fruit.getQuantity());
			FruitController.sale(fruitToSale);
		}
		PurchaseOrderRepository.buyFruits(purchaseOrder);

	}

	public static List<PurchaseOrder> report() {
		List<PurchaseOrder> purchaseOrders = PurchaseOrderRepository.report();
		return purchaseOrders;
	}

}
