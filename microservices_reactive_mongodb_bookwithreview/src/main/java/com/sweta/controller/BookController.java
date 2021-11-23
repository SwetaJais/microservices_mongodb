package com.sweta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.sweta.VO.Rating;
import com.sweta.entity.Book;
import com.sweta.repository.BookRepository;


import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private WebClient.Builder builder;
	
	
	@PostMapping("/add")
	public @ResponseBody Mono<Book> addBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@GetMapping("/get")
	public Flux<Book> getBooks()
	{
		return bookRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public @ResponseBody Mono<Book> findBookById(@PathVariable("id") Long id)
	{
		log.info("Inside  Book controller");
		return bookRepository.findByBookId(id).switchIfEmpty(Mono.error(new Throwable("Book not found")));
	}
	
	
	@GetMapping("/webclient/{id}")
	public Mono<Rating> getBookWithRating(@PathVariable("id") Long id)
	{
			//return builder.build().get().uri("http://localhost:8080/getById/"+id).retrieve().bodyToMono(Rating.class);
			return builder.build().get().uri("http://RATING-SERVICE/getById/"+id).retrieve().bodyToMono(Rating.class); //After registring with eureka-server
	}
}
