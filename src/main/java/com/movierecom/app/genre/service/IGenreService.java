/**
 * 
 */
package com.movierecom.app.genre.service;

import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.genre.bean.bo.GenreBO;

/**
 * @author pravinsharma
 *
 */
public interface IGenreService {
	public GenreBO getById(Long id) throws ServiceException;
	
	public GenreBO getByName(String name) throws ServiceException;
}
