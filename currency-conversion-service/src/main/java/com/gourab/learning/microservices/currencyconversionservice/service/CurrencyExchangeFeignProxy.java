package com.gourab.learning.microservices.currencyconversionservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gourab.learning.microservices.currencyconversionservice.model.ConvertedCurrency;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8001")
//@FeignClient(name = "currency-exchange-service") //Use this when request does not need to pass through Zuul Api Gateway
@FeignClient(name = "zuul-api-gateway-server") //Use this when request need to pass through Zuul Api Gateway
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeFeignProxy {

	//@GetMapping("/currencyExchange/{from}/{to}") //Use this when request does not need to pass through Zuul Api Gateway
	
	/*
	 * Use this when request need to pass through Zuul Api Gateway using Feign
	 * Syntax :- <currency-exchange-appliction-name>/uri
	 * From Browser:-http://localhost:<portOfZuul>/<currency-exchange-appliction-name>/uri
	 */
	@GetMapping("currency-exchange-service/currencyExchange/{from}/{to}") 
	public ConvertedCurrency getCurrencyExchangeInfo(@PathVariable String from, @PathVariable String to); 
}
