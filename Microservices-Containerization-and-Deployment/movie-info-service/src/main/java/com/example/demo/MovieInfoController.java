package com.example.demo;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")

public class MovieInfoController {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId)
	{
		return new Movie(movieId,"Test name");
	}
	

}
