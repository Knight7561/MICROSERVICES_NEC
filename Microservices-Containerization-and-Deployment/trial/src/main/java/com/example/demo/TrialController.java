package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrialController {
	
	@RequestMapping("/home")
	public String print()
	{
		return "hello world";
	}

	
}
