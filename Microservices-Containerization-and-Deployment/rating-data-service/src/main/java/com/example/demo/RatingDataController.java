package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataController {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId)
	{
		return new Rating(movieId,4);
	}
	
	//added in step 2
	//instead of hardcoding in "movie-catalog-service", call this api there
	@RequestMapping("/users/{userId}")
	
	//change from List<Rating> to userRating in step 3 ending
	public UserRating getUserRating(@PathVariable("userId") String userId)
	{
		List<Rating> ratings = Arrays.asList(new Rating("1234",4),new Rating("5678",3));
		//return ratings;
		//added in step 3 starting
		//create a class UserRating
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}