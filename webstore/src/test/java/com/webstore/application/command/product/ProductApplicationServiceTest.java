package com.webstore.application.command.product;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.webstore.domain.product.Product;
import com.webstore.domain.product.ProductFactory;
import com.webstore.domain.product.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductApplicationServiceTest {

	@InjectMocks
	private ProductApplicationService service;
	@Mock
	private ProductRepository repository;
	@Mock
	private ProductFactory factory;
	@Mock
	private ProductAttributes attributes;
	
	@Before
	public void before() {
		Mockito.when(attributes.getDescription()).thenReturn("product description");
		Mockito.when(attributes.getName()).thenReturn("product name");
		Mockito.when(attributes.getNumber()).thenReturn("product number");
		Mockito.when(attributes.getPrice()).thenReturn(new BigDecimal("100.0"));
		Mockito.when(attributes.getTotalNumber()).thenReturn(10);
	}
	
	@Test
	public void shouldAddNewProduct() {
		//given
		Mockito.when(repository.doesProductWithNumberAlreadyExists("number")).thenReturn(false);
		
		//when
		service.addProduct(attributes);
		
		//then
		ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
		Mockito.verify(repository).save(productArgumentCaptor.capture());

		
		Product product = productArgumentCaptor.getValue();
		
		//TODO pozostale pola
		//Assertions.assertThat(product.id()).isEqualTo(1L);
	}
	
	@Test
	public void shouldThrowExceptionWhenProductWithNumberAlreadyExists() {
		//given
		IllegalArgumentException expectedException = new IllegalArgumentException("Product already exists");
		
		Mockito.when(repository.doesProductWithNumberAlreadyExists("number")).thenReturn(true);
	
		//when
		try {
			service.addProduct(attributes);
			Fail.fail("Expect exception");
		} catch(Exception e) {
			Assertions.assertThat(e).isEqualTo(expectedException);
		}
	}
}
