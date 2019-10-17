package com.novopay.MicroserviceD;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
public class MicroserviceDApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDApplication.class, args);
	}

}


@RestController
class MicroserviceDController {
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
		
	
	
	@GetMapping(value= "/microservice4")
	public String method4() {
		LOG.info("Inside Method4");
		return "Last microservice call ";
		
	}
	
	
}