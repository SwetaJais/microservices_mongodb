package com.sweta.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "bookwithratings")
public class Book {

	@Id
	private long bookId;
	private String title;
	private String author;
    private long ratingId;
	
	
}
