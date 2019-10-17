package com.novopay.MicroserviceA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
class MicroserviceAController {
	private static Logger logger = LoggerFactory.getLogger(MicroserviceAController.class);
	
	@Autowired
	RestTemplate restTemplate;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
	
	@GetMapping(value= "/microservice1")
	public String method1() {
		logger.info("Inside Method1");
		String baseURL = "http://localhost:8082/microservice2";
		String response = (String) restTemplate.exchange(baseURL, HttpMethod.GET, null, String.class).getBody();
		logger.info("The response received by method1 is " + response);
		return response;
		
	}
	
	
}