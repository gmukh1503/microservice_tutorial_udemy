package com.gourab.learning.microservices.currencyconversionservice.model;

import java.math.BigDecimal;

public class ConvertedCurrency {

		//private Long id;
		private String from;
		private String to;
		private BigDecimal quantity;
		private BigDecimal conversionMultiple;
		private BigDecimal convertedAmount;
		private int port;
		
	/*
	 * public Long getId() { return id; } public void setId(Long id) { this.id = id;
	 * }
	 */
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public BigDecimal getConversionMultiple() {
			return conversionMultiple;
		}
		public void setConversionMultiple(BigDecimal conversionMultiple) {
			this.conversionMultiple = conversionMultiple;
		}
		public BigDecimal getConvertedAmount() {
			return convertedAmount;
		}
		public void setConvertedAmount(BigDecimal convertedAmount) {
			this.convertedAmount = convertedAmount;
		}
		public int getPort() {
			return port;
		}
		public void setPort(int port) {
			this.port = port;
		}
		public BigDecimal getQuantity() {
			return quantity;
		}
		public void setQuantity(BigDecimal quantity) {
			this.quantity = quantity;
		}
		
		
		
}
