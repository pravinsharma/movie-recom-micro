/**
 * 
 */
package com.movierecom.app.movieswatched.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.movieswatched.bean.bo.MoviesWatchedBO;
import com.movierecom.app.movieswatched.repository.MoviesWatchedRepository;
import com.movierecom.app.users.bean.bo.UsersBO;

/**
 * @author pravinsharma
 *
 */
@Component
public class MoviesWatchedDAO implements IMoviesWatchedDAO {
	private static final Logger LOG = LoggerFactory.getLogger(MoviesWatchedDAO.class);
	
	@Autowired
	MoviesWatchedRepository repository;
	
	public MoviesWatchedBO getById(Long id) throws DAOException {
		MoviesWatchedBO moviesWatchedBO = null;
		
		try {
			moviesWatchedBO = repository.getOne(id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return moviesWatchedBO;
	}

	@Override
	public List<MoviesWatchedBO> getByUser(UsersBO usersBO) throws DAOException {
		List<MoviesWatchedBO> moviesWatchedBOList = null;
		
		try {
			moviesWatchedBOList = repository.getByUsers(usersBO);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return moviesWatchedBOList;
	}
}
