/**
 * 
 */
package com.movierecom.app.movies.bean.bo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.movierecom.app.genre.bean.bo.GenreBO;

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
@Entity
@Table(name="movies")
public class MoviesBO {
	@Id
	@SequenceGenerator(name="movies_id_seq", sequenceName = "movies_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movies_id_seq")
	@Column(updatable = false)
	private Long id;
	
	private String name;
	
	private String year;
	
	@ManyToOne
	@JoinColumn(name = "genreid")
	private GenreBO genre;
	
	private String summary;
	
	@Transient
	private LocalDateTime createdat;
	
	public MoviesBO(String name, String year, GenreBO genre, String summary) {
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.summary = summary;
	}
}
