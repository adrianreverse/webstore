package com.webstore.domain.product;

import org.springframework.stereotype.Component;

import com.common.domain.Money;

/**
 * 
 * @author Adrian Dudziak
 *
 */
@Component
public class ProductFactory {

	/**
	 * 
	 * @param values, not-null
	 * @return, not-null
	 */
	public Product createProduct(ProductValues values) {
		// TODO assertions

		String number = values.getNumber();
		String name = values.getName();
		Money price = new Money(values.getPrice());
		String description = values.getDescription();
		int totalNumber = values.getTotalNumber();

		return new Product(number, name, price, description, totalNumber);
	}
	
}
