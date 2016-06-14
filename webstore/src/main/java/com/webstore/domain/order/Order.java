package com.webstore.domain.order;

import java.time.LocalDateTime;

import com.common.domain.AbstractEntity;
import com.common.domain.Money;

/**
 * 
 * @author Adrian Dudziak
 *
 */
public class Order extends AbstractEntity {

	//ref do usera ktory zlozyl zamowienie
	//private Client client
	
	//ref do order items
	
	private LocalDateTime orderDate;
	
	private LocalDateTime realizationDate;
	
	private OrderStatus status;
	
	private Money price;
	
	Order(/*Client client,*/) {
		
	}
	
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
