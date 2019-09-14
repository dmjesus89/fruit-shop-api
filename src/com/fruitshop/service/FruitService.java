package com.fruitshop.service;

import java.math.BigDecimal;
import java.util.List;

import com.fruitshop.domain.Fruit;
import com.fruitshop.exception.BadRequestException;
import com.fruitshop.exception.ResourceNotFound;
import com.fruitshop.repository.FruitRepository;

/**
 * service and busines role make some operations in Fruit Because it's a test I
 * put the validation in the same class, but in the bigger Project I will
 * separete the validations
 * 
 * @author oliveira
 *
 */
public class FruitService {

	public static void save(Fruit fruit) {
		if (fruit.getName().isEmpty() || fruit.getPrice() == new BigDecimal(0) || fruit.getQuantity() == 0) {
			throw new BadRequestException("Bad Request - Code: 400 Message: Parameters invalid ");
		}
		Fruit fruitAlreadySaved = FruitRepository.findByName(fruit.getName());
		if (fruitAlreadySaved == null) {
			FruitRepository.save(fruit);
		} else {
			Integer quantityFinal = fruit.getQuantity() + fruitAlreadySaved.getQuantity();
			fruitAlreadySaved.setQuantity(quantityFinal);
			FruitRepository.updateQuantity(fruitAlreadySaved);
		}

	}

	public static void sale(Fruit fruit) {
		Fruit fruitAlreadySaved = FruitRepository.findById(fruit.getId());
		if (fruitAlreadySaved == null) {
			throw new ResourceNotFound("Resource not found - Code: 404 Message: fruit not found ");
		}

		if (fruit.getQuantity() > fruitAlreadySaved.getQuantity()) {
			throw new BadRequestException("Bad Request - Code: 400 Message: invalid value to quantity fruit ");
		}

		Integer quantityFinal = fruitAlreadySaved.getQuantity() - fruit.getQuantity();
		fruit.setQuantity(quantityFinal);
		FruitRepository.updateQuantity(fruit);

	}

	public static List<Fruit> getAll() {
		return FruitRepository.findAll();
	}

	public static Fruit findByName(String name) {
		Fruit fruitAlreadySaved = FruitRepository.findByName(name);
		if (fruitAlreadySaved == null) {
			throw new ResourceNotFound("Resource not found - Code: 404 Message: fruit not found ");
		}
		return fruitAlreadySaved;
	}

	public static Fruit findById(Long id) {

		Fruit fruitAlreadySaved = FruitRepository.findById(id);
		if (fruitAlreadySaved == null) {
			throw new ResourceNotFound("Resource not found - Code: 404 Message: fruit not found ");
		}
		return fruitAlreadySaved;
	}
}
