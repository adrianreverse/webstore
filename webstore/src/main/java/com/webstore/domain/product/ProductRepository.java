package com.webstore.domain.product;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author Adrian Dudziak
 *
 */
@Repository
public interface ProductRepository {

	/**
	 * 
	 * @param product, not-null
	 */
	void save(Product product);
	
	/**
	 * 
	 * @param number, not-null, not-empty
	 */
	boolean doesProductWithNumberAlreadyExists(String number);
}
