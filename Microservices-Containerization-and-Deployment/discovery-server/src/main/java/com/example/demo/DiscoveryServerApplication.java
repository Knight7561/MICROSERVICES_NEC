package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*there is discover server which is eureka server in between, to the left we have client which is the eureka client
 and to the right we have multiple services which are also eureka clients. The services register
 themselves with the discovery server and the client ask discovery server for the services. So no need to
 hardcode the url now. So in order to create the eureka server, we need to create a simple spring boot application
 in which the dependency to be included is "Discovery Server".Since jdk 11 is used some dependencies need
 to be added to pom.xml because they are deprecated in java 11, if not added error will occur.
 The first step is starting the eureka server, the next step is registering microservices with the server,
 the next step is client consuming the microservice. The default port is 8971. Three lines need to added to
 application.properties file bcz eureka server tries to find other eureka servers and tries to act as a client.*/

/* To all microservices add @EnableEurekaClient and add client dependency and spring cloud version in pom.xml*/

/* register all three microservices as eureka clients */


@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}

}
