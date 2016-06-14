package com.webstore.application.command.product;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.webstore.domain.product.Product;
import com.webstore.domain.product.ProductFactory;
import com.webstore.domain.product.ProductRepository;

/**
 * 
 * @author Adrian Dudziak
 *
 */
@Service
public class ProductApplicationService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductFactory productFactory;
	
	//TODO @Transactional
	public void addProduct(ProductAttributes attributes) {
		validateAttributes(attributes);
		
		Product product = productFactory.createProduct(attributes);
		productRepository.save(product);
	}
	
	private void validateAttributes(ProductAttributes attributes) {
		Assert.notNull(attributes, "attributes");
		//TODO asercje
		
		boolean doesProductWithNumberAlreadyExists 
			= productRepository.doesProductWithNumberAlreadyExists(attributes.getNumber());
		//TODO napisac isFalse
		Assert.isTrue(!doesProductWithNumberAlreadyExists, "Product already exists");
		
		boolean doesPriceIsGratherThanZero = attributes.getPrice().compareTo(BigDecimal.ZERO) > 0;
		Assert.isTrue(doesPriceIsGratherThanZero, "Price is lower or equlas zero");
		
		boolean doesTotalNumberGratherThanZero = attributes.getTotalNumber() > 0;
		Assert.isTrue(doesTotalNumberGratherThanZero, "Total number is lower or equlas zero");
	}
}
