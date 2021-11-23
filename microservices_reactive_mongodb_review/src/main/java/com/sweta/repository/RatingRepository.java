package com.sweta.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sweta.entity.Rating;

import reactor.core.publisher.Mono;


@Repository
public interface RatingRepository extends ReactiveMongoRepository<Rating,Long> {

	Mono<Rating> findByRatingId(Long id);



}
