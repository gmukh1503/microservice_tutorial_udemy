package com.gourab.learning.microservices.currencyconversionservice.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gourab.learning.microservices.currencyconversionservice.model.ConvertedCurrency;
import com.gourab.learning.microservices.currencyconversionservice.utility.CurrencyConversionUtility;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
@EnableCircuitBreaker
public class CurrencyConversionService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyExchangeFeignProxy feignProxy;

	/*
	 * Invoking external Microservice using RestTemplate.
	 */
	public ResponseEntity<ConvertedCurrency> getConvertedCurrency(String from, String to, BigDecimal quantity) {
		Map<String,String> uriVariablesMap = new HashMap<String,String> ();
		uriVariablesMap.put("from", from);
		uriVariablesMap.put("to", to);
		String url = "http://currency-exchange-service/currencyExchange/{from}/{to}";
		ResponseEntity<ConvertedCurrency> convCurrencyRespEntity = restTemplate.getForEntity(url, ConvertedCurrency.class, uriVariablesMap);
		return CurrencyConversionUtility.doCurrencyConversion(convCurrencyRespEntity,quantity);
		
	}
	
	/*
	 * Invoking external Microservice using Feign/OpenFeign.
	 */
	public ResponseEntity<ConvertedCurrency> getConvertedCurrencyFeign(String from, String to, BigDecimal quantity) {
		
		ConvertedCurrency convertedCurrency = feignProxy.getCurrencyExchangeInfo(from, to);
		return CurrencyConversionUtility.doCurrencyConversionFeign(convertedCurrency, quantity);
		
	}

	@HystrixCommand(fallbackMethod = "getConvertedCurrencyFaultTolrncFallback")
	public ResponseEntity<ConvertedCurrency> getConvertedCurrencyFaultTolrnc(String from, String to,
			BigDecimal quantity) {
		throw new RuntimeException("Purposely thrown to handle fault tolerance");
	}
	
	
	public ResponseEntity<ConvertedCurrency> getConvertedCurrencyFaultTolrncFallback(String from, String to,
			BigDecimal quantity){
		ConvertedCurrency convertedCurrency = new ConvertedCurrency();
		convertedCurrency.setFrom(from);
		convertedCurrency.setTo(to);
		convertedCurrency.setQuantity(quantity);
		return new ResponseEntity<>(convertedCurrency, HttpStatus.PARTIAL_CONTENT);
		
	}
}
