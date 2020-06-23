//rest controller
package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")

//adding classes "Movie", "Rating" and "UserRating"
public class MovieCatalogController {
	
	//in order to get the bean (injecting the bean)
	@Autowired RestTemplate restTemplate; /*RestTemplate/synchronous (deprecating soon) is required in order to call any 
	other microservice, alternative of this is WebClient/asynchronous */
	
	//@Autowired WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
	{	
		/*RestTemplate restTemplate=new RestTemplate(); IT CREATES INSTANCE EACH TIME SO IS REMOVED AND BEAN 
		IS INJECTED INSTEAD*/
		
		//WebClient requires Reactive Web whereas RestTemplate requires Spring Web
		//add spring-boot-starter-webflux to pom.xml for WebClient
		/*WebClient.Builder builder = WebClient.builder() IT CREATES INSTANCE EACH TIME SO IS REMOVED AND BEAN 
		IS INJECTED INSTEAD*/
		
		//get all rated movie ids from "rating-data-service"
		//instead of hardcoding here, call an API to get the same thing from "RatingDataConroller"
		//List<Rating> ratings = Arrays.asList(new Rating("1234",4),new Rating("5678",3));
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId, UserRating.class);
		//we replaced localhost:8083 by rating-data-service by using server discovery since we hv used @LoadBalanced
		
		
		//for each movie id call "movie-info-service"
		return ratings.getUserRating().stream().map(rating -> {
			
			//the root node of an API should always be an object
		   Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
		   //we replaced localhost:8082 by movie-info-service by using server discovery since we hv used @LoadBalanced
		   
		   /*
		    Movie movie = webClientBuilder.build()
		    .get()
		    .url("http://localhost:8082/movies/"+rating.getMovieId())
		    .retrieve()
		    .bodyToMono( Movie.class) //IN THE FUTURE WILL GIVE US AN ASYNCHRONOUS OBJECT (analogus to promise in JS)
		    .block();
		    */
		    
		   //put them all together using "movie-catalog-service"
		   return new CatalogItem(movie.getName(),"Desc",rating.getRating());
		}).collect(Collectors.toList());
	}

}
