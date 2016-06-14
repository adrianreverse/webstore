package com.webstore.application.command.product;

import com.webstore.domain.product.ProductValues;

/**
 * 
 * @author Adrian Dudziak
 *
 */
public interface ProductAttributes extends ProductValues {

	Long getId();
	
	int getConcurrencyVersion();
}
