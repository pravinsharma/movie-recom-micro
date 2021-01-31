/**
 * 
 */
package com.movierecom.app.genre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movierecom.app.genre.bean.bo.GenreBO;

/**
 * @author pravinsharma
 *
 */
@Repository
public interface GenreRepository extends JpaRepository<GenreBO, Long> {
	public GenreBO getByName(String name);
}
