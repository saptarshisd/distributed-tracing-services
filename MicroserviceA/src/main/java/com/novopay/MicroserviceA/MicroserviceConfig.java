package com.novopay.MicroserviceA;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

//import org.springframework.

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MicroserviceConfig {
	
	
	@Bean
	public RestTemplate getRestTemplate() {
			return new RestTemplate();
	}
	
	
	//Sampling
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
