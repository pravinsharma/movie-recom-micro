/**
 * 
 */
package com.movierecom.app.genre.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.genre.bean.bo.GenreBO;
import com.movierecom.app.genre.dao.GenreDAO;

/**
 * @author pravinsharma
 *
 */
@Component
public class GenreService implements IGenreService {
	private static final Logger LOG = LoggerFactory.getLogger(GenreService.class);
	
	@Autowired
	GenreDAO dao;

	@Override
	public GenreBO getById(Long id) throws ServiceException {
		GenreBO genreBO = null;
		
		try {
			genreBO = dao.getById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return genreBO;
	}

	@Override
	public GenreBO getByName(String name) throws ServiceException {
		GenreBO genreBO = null;
		
		try {
			genreBO = dao.getByName(name);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return genreBO;
	}
}
