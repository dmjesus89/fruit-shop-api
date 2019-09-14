package com.fruitshop.controller;

import java.util.List;

import com.fruitshop.domain.Fruit;
import com.fruitshop.service.FruitService;

/**
 * Resource Fruit to save and update the quantity of fruit
 * 
 * @author oliveira
 *
 */
public class FruitController {

	// HTT POST with bodyrequest
	public static void save(Fruit fruit) {
		FruitService.save(fruit);

	}

	// HTTP PUT
	public static void sale(Fruit fruit) {
		FruitService.sale(fruit);
	}

	// HTTP GET
	public static List<Fruit> report() {
		return FruitService.getAll();
	}

	public static Fruit findByName(String name) {
		return FruitService.findByName(name);
	}

	public static Fruit findById(Long id) {
		return FruitService.findById(id);
	}
}
