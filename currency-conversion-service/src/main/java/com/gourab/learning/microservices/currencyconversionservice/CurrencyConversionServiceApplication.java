package com.gourab.learning.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.gourab.learning.microservices.currencyconversionservice") //Scan for all interfaces which are annotated with @FeignClient
@EnableDiscoveryClient //@EnableDiscoveryClient -is generic and works for(eureka, consul, zookeeper), @EnableEurekaClient -is specific to Eureka
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

}
