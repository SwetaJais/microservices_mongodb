package com.sweta.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweta.entity.Rating;
import com.sweta.repository.RatingRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class RatingController {

	@Autowired
	private RatingRepository ratingrepository;
	
	
	@PostMapping("/add")
	public @ResponseBody Mono<Rating> addReviews(@RequestBody Rating review)
	{
		return ratingrepository.save(review);
	}
	
	@GetMapping("/getById/{id}")
	public @ResponseBody Mono<Rating> findRatingById(@PathVariable("id") Long id)
	{
		log.info("Inside  Book controller");
		return ratingrepository.findByRatingId(id).switchIfEmpty(Mono.error(new Throwable("No ratings are there")));
	}
	
}
