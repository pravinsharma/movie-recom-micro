/**
 * 
 */
package com.movierecom.app.movies.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.genre.bean.bo.GenreBO;
import com.movierecom.app.genre.dao.IGenreDAO;
import com.movierecom.app.movies.bean.bo.MoviesBO;
import com.movierecom.app.movies.bean.mapper.MoviesMapper;
import com.movierecom.app.movies.bean.vo.MoviesVO;
import com.movierecom.app.movies.dao.IMoviesDAO;
import com.movierecom.app.util.StringUtil;

/**
 * @author pravinsharma
 *
 */
@Service
public class MoviesService implements IMoviesService {
	private static final Logger LOG = LoggerFactory.getLogger(MoviesService.class);
	
	@Autowired
	IMoviesDAO moviesDAO;
	
	@Autowired
	IGenreDAO genreDAO;

	@Override
	public MoviesVO getById(Long id) throws ServiceException {
		MoviesVO movies = null;
		
		if (id == null) {
			throw new ServiceException("Insufficient parameters...");
		}
		
		try {
			MoviesBO bo = moviesDAO.getById(id);
			movies = MoviesMapper.fromBO(bo);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return movies;
	}

	@Override
	public List<MoviesVO> getByName(String name) throws ServiceException {
		List<MoviesVO> moviesList = null;
		
		if (StringUtil.isEmpty(name)) {
			throw new ServiceException("Insufficient parameters...");
		}
		
		try {
			List<MoviesBO> boList = moviesDAO.getByName(name);
			moviesList = MoviesMapper.fromBO(boList);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return moviesList;
	}

	@Override
	public List<MoviesVO> getByNameAndYear(String name, String year) throws ServiceException {
		List<MoviesVO> moviesList = null;
		
		if (!StringUtil.isAllFull(name, year)) {
			throw new ServiceException("Insufficient parameters...");
		}
		
		try {
			List<MoviesBO> boList = moviesDAO.getByNameAndYear(name, year);
			moviesList = MoviesMapper.fromBO(boList);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return moviesList;
	}

	@Override
	public List<MoviesVO> getByNameAndGenre(String name, String genre) throws ServiceException {
		List<MoviesVO> moviesList = null;
		
		if (!StringUtil.isAllFull(name, genre)) {
			throw new ServiceException("Insufficient parameters...");
		}
		
		try {
			GenreBO genreBO = genreDAO.getByName(genre);
			
			if (genreBO == null) {
				throw new ServiceException("Genre not found...");
			}
			
			List<MoviesBO> boList = moviesDAO.getByNameAndGenre(name, genreBO);
			moviesList = MoviesMapper.fromBO(boList);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return moviesList;
	}

	@Override
	public List<MoviesVO> getByYear(String year) throws ServiceException {
		List<MoviesVO> moviesList = null;
		
		if (StringUtil.isEmpty(year)) {
			throw new ServiceException("Insufficient parameters...");
		}
		
		try {
			List<MoviesBO> boList = moviesDAO.getByYear(year);
			moviesList = MoviesMapper.fromBO(boList);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return moviesList;
	}

	@Override
	public List<MoviesVO> getByYearAndGenre(String year, String genre) throws ServiceException {
		List<MoviesVO> moviesList = null;
		
		if (!StringUtil.isAllFull(year, genre)) {
			throw new ServiceException("Insufficient parameters...");
		}
		
		try {
			GenreBO genreBO = genreDAO.getByName(genre);
			
			if (genreBO == null) {
				throw new ServiceException("Genre not found...");
			}
			
			List<MoviesBO> boList = moviesDAO.getByYearAndGenre(year, genreBO);
			moviesList = MoviesMapper.fromBO(boList);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return moviesList;
	}

	@Override
	public List<MoviesVO> getByGenre(String genre) throws ServiceException {
		List<MoviesVO> moviesList = null;
		
		if (StringUtil.isEmpty(genre)) {
			throw new ServiceException("Insufficient parameters...");
		}
		
		try {
			GenreBO genreBO = genreDAO.getByName(genre);
			
			if (genreBO == null) {
				throw new ServiceException("Genre not found...");
			}
			
			List<MoviesBO> boList = moviesDAO.getByGenre(genreBO);
			moviesList = MoviesMapper.fromBO(boList);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return moviesList;
	}

	@Override
	public void save(MoviesVO movies) throws ServiceException {
		
		if (movies == null) {
			throw new ServiceException("Insufficient parameters...");
		}
		
		try {
			moviesDAO.save(MoviesMapper.toBO(movies));
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
