/**
 * 
 */
package com.movierecom.app.movieswatched.bean.bo;

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

import com.movierecom.app.movies.bean.bo.MoviesBO;
import com.movierecom.app.users.bean.bo.UsersBO;

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
@Table(name="movieswatched")
public class MoviesWatchedBO {
	@Id
	@SequenceGenerator(name="movieswatched_id_seq", sequenceName = "movieswatched_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieswatched_id_seq")
	@Column(updatable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "moviesid")
	private MoviesBO movies;
	
	@ManyToOne
	@JoinColumn(name = "usersid")
	private UsersBO users;
	
	@Transient
	private LocalDateTime createdat;
	
	public MoviesWatchedBO(MoviesBO moviesBO, UsersBO usersBO) {
		this.movies = moviesBO;
		this.users = usersBO;
	}
}
