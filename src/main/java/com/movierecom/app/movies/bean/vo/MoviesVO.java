/**
 * 
 */
package com.movierecom.app.movies.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pravinsharma
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesVO {
	private String name;
	
	private String year;
	
	private String genre;
	
	private String summary;
}
