package com.gourab.learning.microservices.currencyconversionservice.utility;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gourab.learning.microservices.currencyconversionservice.model.ConvertedCurrency;

public class CurrencyConversionUtility {

	public static ResponseEntity<ConvertedCurrency> doCurrencyConversion(ResponseEntity<ConvertedCurrency> convCurrencyRespEntity, BigDecimal quantity) {
		if(null!=convCurrencyRespEntity) {
			ConvertedCurrency convertedCurrency = convCurrencyRespEntity.getBody();
			convertedCurrency.setQuantity(quantity);
			convertedCurrency.setConvertedAmount(quantity.multiply( convertedCurrency.getConversionMultiple()));
		}
		
		return convCurrencyRespEntity;
		
	}
	
	public static ResponseEntity<ConvertedCurrency> doCurrencyConversionFeign(ConvertedCurrency convertedCurrency, BigDecimal quantity) {
			convertedCurrency.setQuantity(quantity);
			convertedCurrency.setConvertedAmount(quantity.multiply( convertedCurrency.getConversionMultiple()));
			return new ResponseEntity<ConvertedCurrency>(convertedCurrency, HttpStatus.OK);
	}
}
