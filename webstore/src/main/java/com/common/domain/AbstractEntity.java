package com.common.domain;

/**
 * 
 * @author Adrian Dudziak
 *
 */
public abstract class AbstractEntity {

	private Long id;
	private int concurrencyVersion;
	
	public Long id() {
		return this.id;
	}
	
	public int concurrencyVersion() {
		return concurrencyVersion;
	}
	
	public abstract boolean equals(final Object obj);
	
	public abstract int hashCode();

}
