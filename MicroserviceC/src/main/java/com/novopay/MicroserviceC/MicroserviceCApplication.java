package com.novopay.MicroserviceC;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
public class MicroserviceCApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCApplication.class, args);
	}

}


@RestController
class MicroserviceCController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
			return new RestTemplate();
	}
	
	//Sampling
		@Bean
		public Sampler defaultSampler() {
			return Sampler.ALWAYS_SAMPLE;
		}
		
	
	
	@GetMapping(value= "/microservice3")
	public String method1() {
		LOG.info("Inside Method3");
		String baseURL = "http://localhost:8083/microservice4";
		String response = (String) restTemplate.exchange(baseURL, HttpMethod.GET, null, String.class).getBody();
		LOG.info("The response received by method3 is " + response);
		return response;
		
	}
	
	
}