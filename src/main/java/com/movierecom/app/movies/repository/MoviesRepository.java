/**
 * 
 */
package com.movierecom.app.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movierecom.app.genre.bean.bo.GenreBO;
import com.movierecom.app.movies.bean.bo.MoviesBO;

/**
 * @author pravinsharma
 *
 */
@Repository
public interface MoviesRepository extends JpaRepository<MoviesBO, Long> {
	public List<MoviesBO> getByName(String name);
	
	public List<MoviesBO> getByNameAndYear(String name, String year);
	
	public List<MoviesBO> getByNameAndGenre(String name, GenreBO genre);
	
	public List<MoviesBO> getByYear(String year);
	
	public List<MoviesBO> getByYearAndGenre(String year, GenreBO genre);
	
	public List<MoviesBO> getByGenre(GenreBO genre);
}
