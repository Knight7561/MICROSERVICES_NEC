//created after adding step 2 to RatingDataController
package com.example.demo;

import java.util.List;

public class UserRating {

	public List<Rating> userRating;

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
}
