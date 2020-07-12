package com.example.cruddiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CrudDiscoveryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudDiscoveryServiceApplication.class, args);
	}

}
