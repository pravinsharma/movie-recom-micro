/**
 * 
 */
package com.movierecom.app.genre.bean.bo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name="genre")
public class GenreBO {
	@Id
	@SequenceGenerator(name="genre_id_seq", sequenceName = "genre_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_id_seq")
	@Column(updatable = false)
	private Long id;
	
	@Column(updatable = false)
	private String name;
	
	@Transient
	private LocalDateTime createdat;
	
	public GenreBO(String name) {
		this.name = name;
	}
}
