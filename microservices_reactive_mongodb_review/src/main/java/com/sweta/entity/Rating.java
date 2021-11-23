package com.sweta.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "ratings")
public class Rating {
	
	private long ratingId;
	private double ratings;
	private String comments;
	

}
