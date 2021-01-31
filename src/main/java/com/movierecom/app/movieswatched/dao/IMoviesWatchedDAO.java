/**
 * 
 */
package com.movierecom.app.movieswatched.dao;

import java.util.List;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.movieswatched.bean.bo.MoviesWatchedBO;
import com.movierecom.app.users.bean.bo.UsersBO;

/**
 * @author pravinsharma
 *
 */
public interface IMoviesWatchedDAO {
	public MoviesWatchedBO getById(Long id) throws DAOException;
	
	public List<MoviesWatchedBO> getByUser(UsersBO usersBO) throws DAOException;
}
