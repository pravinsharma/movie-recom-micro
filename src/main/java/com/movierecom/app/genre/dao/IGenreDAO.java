/**
 * 
 */
package com.movierecom.app.genre.dao;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.genre.bean.bo.GenreBO;

/**
 * @author pravinsharma
 *
 */
public interface IGenreDAO {
	public GenreBO getById(Long id) throws DAOException;
	
	public GenreBO getByName(String name) throws DAOException;
}
