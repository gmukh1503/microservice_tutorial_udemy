package com.gourab.learning.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gourab.learning.microservices.currencyexchangeservice.model.ExchangeValue;
import com.gourab.learning.microservices.currencyexchangeservice.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeService currencyExchangeSrvc;

	public static Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeService.class);
	@GetMapping("/currencyExchange/{from}/{to}")
	public ExchangeValue getCurrencyExchangeInfo(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = currencyExchangeSrvc.getCurrencyExchangeValue(from,to);
		if(null!=exchangeValue)
			exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		
		LOGGER.error("@@@@@@@ExchangeValue :"+exchangeValue);
		return exchangeValue;
	}
}
