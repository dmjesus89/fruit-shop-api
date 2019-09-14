package com.fruitshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fruitshop.controller.FruitController;
import com.fruitshop.controller.PurchaseOrderController;
import com.fruitshop.domain.Fruit;
import com.fruitshop.domain.PurchaseOrder;

/**
 * Main to make the operations save, salve it's a simulation of some client
 * (another api or a front end app)
 * 
 * @author oliveira
 *
 */
public class Main {

	public static void main(String[] args) {

		// CRUD
		saveApple();
		saveBanana();
		sale2Apple();
		saveMorApple();
		reportOfFruit();

		// FUNCTIONALITY
		buy();
		reportOfPurchase();
		reportOfFruit();

	}

	public static void saveApple() {
		Fruit apple = new Fruit();
		apple.setName("Apple");
		apple.setPrice(new BigDecimal(2));
		apple.setQuantity(5);
		FruitController.save(apple);

	}

	public static void saveBanana() {
		Fruit banana = new Fruit();
		banana.setName("Banana");
		banana.setPrice(new BigDecimal(5));
		banana.setQuantity(1);
		FruitController.save(banana);

	}

	public static void sale2Apple() {
		Fruit appleToSale = new Fruit();
		Long id = FruitController.findByName("Apple").getId();
		appleToSale.setId(id);
		appleToSale.setQuantity(2);
		FruitController.sale(appleToSale);

	}

	public static void saveMorApple() {
		Fruit apple = new Fruit();
		apple.setName("Apple");
		apple.setPrice(new BigDecimal(2));
		apple.setQuantity(5);
		FruitController.save(apple);

	}

	public static void reportOfFruit() {
		List<Fruit> lstFruits = FruitController.report();
		System.out.println(lstFruits);
	}

	public static void buy() {
		Fruit appleToSale = new Fruit();
		Long idApple = FruitController.findByName("Apple").getId();
		Fruit apple = FruitController.findById(idApple);
		appleToSale.setId(idApple);
		appleToSale.setQuantity(1);
		appleToSale.setName(apple.getName());
		appleToSale.setPrice(apple.getPrice());

		Fruit bananaToSale = new Fruit();
		Long idBanana = FruitController.findByName("Banana").getId();
		Fruit banana = FruitController.findById(idBanana);
		bananaToSale.setId(idBanana);
		bananaToSale.setQuantity(1);
		bananaToSale.setName(banana.getName());
		bananaToSale.setPrice(banana.getPrice());

		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setFruits(new ArrayList<Fruit>());
		purchaseOrder.getFruits().addAll(Arrays.asList(appleToSale, bananaToSale));
		System.out.println(purchaseOrder.getTotalPrice());

		PurchaseOrderController.buyFruits(purchaseOrder);

	}

	public static void reportOfPurchase() {
		List<PurchaseOrder> lstPurchase = PurchaseOrderController.report();
		System.out.println(lstPurchase);
	}

}
