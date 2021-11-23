package com.sweta.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	
	private long ratingId;
	private double ratings;
	private String comments;
	

}
