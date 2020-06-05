package com.gourab.learning.microservices.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourab.learning.microservices.currencyexchangeservice.model.ExchangeValue;
import com.gourab.learning.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	public ExchangeValue getCurrencyExchangeValue(String from, String to) {
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}

}
