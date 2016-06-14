package com.webstore.ui;

import java.io.Serializable;
import java.math.BigDecimal;

import com.webstore.application.command.product.ProductAttributes;

/**
 * 
 * @author Adrian Dudziak
 *
 */
public class ProductAttributesEditForm implements Serializable, ProductAttributes {

	private static final long serialVersionUID = 1L;

	private Long id;
	private int concurrencyVersion;
	private String number;
	private String name;
	private BigDecimal price;
	private int totalNumber;
	private String description;

	//@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//@Override
	public int getConcurrencyVersion() {
		return concurrencyVersion;
	}

	public void setConcurrencyVersion(int concurrencyVersion) {
		this.concurrencyVersion = concurrencyVersion;
	}

	//@Override
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	//@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@Override
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	//@Override
	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	//@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
