package com.gourab.learning.microservices.currencyconversionservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CurrencyConversionConfiguration {

	@Bean
	@LoadBalanced  //Client side Load Balancing by Eureka.
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
