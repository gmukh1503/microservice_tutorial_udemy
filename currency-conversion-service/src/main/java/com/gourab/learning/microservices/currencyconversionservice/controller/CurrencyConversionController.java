package com.gourab.learning.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gourab.learning.microservices.currencyconversionservice.model.ConvertedCurrency;
import com.gourab.learning.microservices.currencyconversionservice.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {
	
	public static Logger LOGGER = LoggerFactory.getLogger(CurrencyConversionController.class);
	
	@Autowired
	private CurrencyConversionService currencyConversionService;
	
	@GetMapping("/currencyConversion/{from}/{to}")
	public ResponseEntity<ConvertedCurrency> getConvertedCurrency(@PathVariable String from ,
													@PathVariable String to, 
													@RequestParam BigDecimal quantity) {
		
		return currencyConversionService.getConvertedCurrency(from,to,quantity);
		
	}
	
	@GetMapping("/currencyConversionFeign/{from}/{to}")
	public ResponseEntity<ConvertedCurrency> getConvertedCurrencyFeign(@PathVariable String from ,
													@PathVariable String to, 
													@RequestParam BigDecimal quantity) {
		LOGGER.error("-----####------Conversion");
		return currencyConversionService.getConvertedCurrencyFeign(from,to,quantity);
		
	}
	
	@GetMapping("/currencyConversion/{from}/{to}/testFaultTolerance")
	public ResponseEntity<ConvertedCurrency> testConvCurrFaultTolerance(@PathVariable String from ,
			@PathVariable String to, 
			@RequestParam BigDecimal quantity){
		return currencyConversionService.getConvertedCurrencyFaultTolrnc(from,to,quantity);
	}

}
