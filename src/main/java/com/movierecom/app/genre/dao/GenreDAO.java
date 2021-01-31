/**
 * 
 */
package com.movierecom.app.genre.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.genre.bean.bo.GenreBO;
import com.movierecom.app.genre.repository.GenreRepository;

/**
 * @author pravinsharma
 *
 */
@Component
public class GenreDAO implements IGenreDAO {
	private static final Logger LOG = LoggerFactory.getLogger(GenreDAO.class);
	
	@Autowired
	GenreRepository repository;

	@Override
	public GenreBO getById(Long id) throws DAOException {
		GenreBO genreBO = null;
		
		try {
			genreBO = repository.getOne(id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return genreBO;
	}

	@Override
	public GenreBO getByName(String name) throws DAOException {
		GenreBO genreBO = null;
		
		try {
			genreBO = repository.getByName(name);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return genreBO;
	}
}
