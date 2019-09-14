package com.fruitshop.controller;

import java.util.List;

import com.fruitshop.domain.PurchaseOrder;
import com.fruitshop.repository.PurchaseOrderRepository;
import com.fruitshop.service.PurchaseOrderService;

public class PurchaseOrderController {

	public static void buyFruits(PurchaseOrder purchaseOrder) {
		PurchaseOrderService.buyFruits(purchaseOrder);
	}

	public static List<PurchaseOrder> report() {
		List<PurchaseOrder> purchaseOrders = PurchaseOrderRepository.report();
		return purchaseOrders;
	}

}
