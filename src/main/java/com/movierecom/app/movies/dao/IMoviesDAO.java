/**
 * 
 */
package com.movierecom.app.movies.dao;

import java.util.List;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.genre.bean.bo.GenreBO;
import com.movierecom.app.movies.bean.bo.MoviesBO;

/**
 * @author pravinsharma
 *
 */
public interface IMoviesDAO {
	public MoviesBO getById(Long id) throws DAOException;
	
	public List<MoviesBO> getByName(String name) throws DAOException;
	
	public List<MoviesBO> getByNameAndYear(String name, String year) throws DAOException;
	
	public List<MoviesBO> getByNameAndGenre(String name, GenreBO genre) throws DAOException;
	
	public List<MoviesBO> getByYear(String year) throws DAOException;
	
	public List<MoviesBO> getByYearAndGenre(String year, GenreBO genre) throws DAOException;
	
	public List<MoviesBO> getByGenre(GenreBO genre) throws DAOException;
	
	public void save(MoviesBO moviesBO) throws DAOException;
}
