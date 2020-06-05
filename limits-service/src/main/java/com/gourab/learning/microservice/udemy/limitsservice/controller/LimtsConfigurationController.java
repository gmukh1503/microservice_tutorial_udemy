package com.gourab.learning.microservice.udemy.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gourab.learning.microservice.udemy.limitsservice.config.AppConfiguration;
import com.gourab.learning.microservice.udemy.limitsservice.dto.LimitConfiguration;

@RestController
public class LimtsConfigurationController {
	
	@Autowired
	private AppConfiguration config;
	
	@GetMapping("/limits")
	public LimitConfiguration fetchLimitConfigurations() {
		return new LimitConfiguration(config.getMinimum(),config.getMaximum());
	}

}
