package com.gourab.learning.microservices.currencyconversionservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;

@Configuration
public class SleuthConfiguration {

	/*
	 * Sampler is responsible for deciding if a particular trace should be "sampled", 
	 * i.e. whether the overhead of tracing will occur and/or if a trace will be reported 
	 * to the collection tier. 
	 * 
	 * Zipkin v1 uses before-the-fact sampling. This means that the decision to keep or drop 
	 * the trace is made before any work is measured, or annotations are added.
	 */
	@Bean
	public Sampler getSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
