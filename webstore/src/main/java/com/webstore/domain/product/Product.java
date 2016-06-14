package com.webstore.domain.product;

import java.time.LocalDateTime;

import com.common.domain.AbstractEntity;
import com.common.domain.Money;

/**
 * 
 * @author Adrian Dudziak
 *
 */
//TODO @Entity
public class Product extends AbstractEntity {

	private String number;
	
	private String name;
	
	private Money price;
	
	private ProductStatus status;
	
	private String description;
	
	private int totalNumber;
	
	private LocalDateTime createDate;
	
	Product(String number, 
			String name, 
			Money price, 
			String description, 
			int totalNumber) {
		//TODO assertions
		
		this.number = number;
		this.name = name;
		this.price = price;
		this.description = description;
		this.totalNumber = totalNumber;
		this.status = ProductStatus.AVAILABLE;
		this.createDate = LocalDateTime.now();
	}
	
	//TODO uzupe³niæ
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
