/**
 * 
 */
package com.movierecom.app.movies.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.genre.bean.bo.GenreBO;
import com.movierecom.app.movies.bean.bo.MoviesBO;
import com.movierecom.app.movies.repository.MoviesRepository;

/**
 * @author pravinsharma
 *
 */
@Component
public class MoviesDAO implements IMoviesDAO {
	private static final Logger LOG = LoggerFactory.getLogger(MoviesDAO.class);
	
	@Autowired
	MoviesRepository repository;

	@Override
	public MoviesBO getById(Long id) throws DAOException {
		MoviesBO moviesBO = null;
		
		try {
			moviesBO = repository.getOne(id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return moviesBO;
	}

	@Override
	public List<MoviesBO> getByName(String name) throws DAOException {
		List<MoviesBO> moviesBOList = null;
		
		try {
			moviesBOList = repository.getByName(name);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return moviesBOList;
	}

	@Override
	public List<MoviesBO> getByNameAndYear(String name, String year) throws DAOException {
		List<MoviesBO> moviesBOList = null;
		
		try {
			moviesBOList = repository.getByNameAndYear(name, year);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return moviesBOList;
	}

	@Override
	public List<MoviesBO> getByNameAndGenre(String name, GenreBO genre) throws DAOException {
		List<MoviesBO> moviesBOList = null;
		
		try {
			moviesBOList = repository.getByNameAndGenre(name, genre);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return moviesBOList;
	}

	@Override
	public List<MoviesBO> getByYear(String year) throws DAOException {
		List<MoviesBO> moviesBOList = null;
		
		try {
			moviesBOList = repository.getByYear(year);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return moviesBOList;
	}

	@Override
	public List<MoviesBO> getByYearAndGenre(String year, GenreBO genre) throws DAOException {
		List<MoviesBO> moviesBOList = null;
		
		try {
			moviesBOList = repository.getByYearAndGenre(year, genre);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return moviesBOList;
	}

	@Override
	public List<MoviesBO> getByGenre(GenreBO genre) throws DAOException {
		List<MoviesBO> moviesBOList = null;
		
		try {
			moviesBOList = repository.getByGenre(genre);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return moviesBOList;
	}
	
	public void save(MoviesBO moviesBO) throws DAOException {
		try {
			repository.save(moviesBO);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}
