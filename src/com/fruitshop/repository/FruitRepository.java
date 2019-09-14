package com.fruitshop.repository;

import java.util.ArrayList;
import java.util.List;

import com.fruitshop.domain.Fruit;

public class FruitRepository {

	private static List<Fruit> dataBaseMockFruit = new ArrayList<Fruit>();
	private static Long idFuitSequence = 0L;

	public static void save(Fruit fruit) {
		fruit.setId(++idFuitSequence);
		dataBaseMockFruit.add(fruit);
	}

	public static Fruit findByName(String name) {
		for (Fruit fruitSaved : dataBaseMockFruit) {
			if (name.equalsIgnoreCase(fruitSaved.getName())) {
				return fruitSaved;
			}
		}
		return null;
	}

	public static Fruit findById(Long id) {
		for (Fruit fruitSaved : dataBaseMockFruit) {
			if (id == fruitSaved.getId()) {
				return fruitSaved;
			}
		}
		return null;
	}

	public static void updateQuantity(Fruit fruit) {
		for (Fruit fruitSaved : dataBaseMockFruit) {
			if (fruit.getId() == fruitSaved.getId()) {
				fruitSaved.setQuantity(fruit.getQuantity());
			}
		}
	}

	public static List<Fruit> findAll() {
		return dataBaseMockFruit;
	}

}
