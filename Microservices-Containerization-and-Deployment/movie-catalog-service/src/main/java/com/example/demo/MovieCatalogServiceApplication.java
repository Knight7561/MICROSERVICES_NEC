package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@EnableFeignClients

public class MovieCatalogServiceApplication {

	//creates a single instance of RestTemplate and this can be injected anywhere using @Autowired
	@Bean
	@LoadBalanced   //does server discovery in a load balanced way //so now rest template looks for hints when 
	//we give it the url to decide which service to call
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	/*@Bean
	public WebClient.Builder getWebClientBuilder()
	{
		return WebClient.builder();
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
