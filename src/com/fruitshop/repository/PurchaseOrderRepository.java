package com.fruitshop.repository;

import java.util.ArrayList;
import java.util.List;

import com.fruitshop.domain.PurchaseOrder;

public class PurchaseOrderRepository {

	private static List<PurchaseOrder> dataBaseMocPurchase = new ArrayList<PurchaseOrder>();
	private static Long idPurchaseSequence = 0L;

	public static void buyFruits(PurchaseOrder purchaseOrder) {
		purchaseOrder.setId(++idPurchaseSequence);
		dataBaseMocPurchase.add(purchaseOrder);
	}

	public static List<PurchaseOrder> report() {
		return dataBaseMocPurchase;
	}

}
