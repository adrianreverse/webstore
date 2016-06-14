package com.webstore.domain.product;

import java.math.BigDecimal;

/**
 * 
 * @author Adrian Dudziak
 *
 */
public interface ProductValues {
	
	/**
	 * 
	 * @return not-null, not-empty
	 */
	String getNumber();
	
	/**
	 * 
	 * @return not-null, not-empty
	 */
	String getName();
	
	/**
	 * 
	 * @return not-null
	 */
	BigDecimal getPrice();
	
	/**
	 * 
	 * @return not-null, not-empty
	 */
	String getDescription();

	int getTotalNumber();

}
