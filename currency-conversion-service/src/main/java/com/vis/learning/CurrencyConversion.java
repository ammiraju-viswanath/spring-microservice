package com.vis.learning;

import java.math.BigDecimal;

public class CurrencyConversion {
	private Long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionMultiple;
	private BigDecimal totalCalculatedAmount;
	private String environment;

	public CurrencyConversion() {

	}

	public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
			BigDecimal totalCalculatedAmount, String environment) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.environment = environment;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public String getFrom() {
		return from;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

}
