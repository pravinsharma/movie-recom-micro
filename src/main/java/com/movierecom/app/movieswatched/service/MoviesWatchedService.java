/**
 * 
 */
package com.movierecom.app.movieswatched.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.movieswatched.bean.bo.MoviesWatchedBO;
import com.movierecom.app.movieswatched.bean.mapper.MoviesWatchedMapper;
import com.movierecom.app.movieswatched.bean.vo.MoviesWatchedVO;
import com.movierecom.app.movieswatched.dao.MoviesWatchedDAO;
import com.movierecom.app.users.bean.bo.UsersBO;
import com.movierecom.app.users.dao.UsersDAO;
import com.movierecom.app.util.StringUtil;

/**
 * @author pravinsharma
 *
 */
@Component
public class MoviesWatchedService implements IMoviesWatchedService {
	private static final Logger LOG = LoggerFactory.getLogger(MoviesWatchedService.class);
	
	@Autowired
	MoviesWatchedDAO moviesWatchedDAO;
	
	@Autowired
	UsersDAO usersDAO;
	
	public MoviesWatchedVO getById(Long id) throws ServiceException {
		MoviesWatchedVO moviesWatched = null;
		
		if (id == null) {
			throw new ServiceException("Insufficient parameters...");
		}
		
		try {
			MoviesWatchedBO bo = moviesWatchedDAO.getById(id);
			
			if (bo == null) {
				throw new ServiceException("No movies found for user...");
			}
			
			moviesWatched = MoviesWatchedMapper.fromBO(bo);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
		return moviesWatched;
	}

	@Override
	public List<MoviesWatchedVO> getByUserName(String userName) throws ServiceException {
		List<MoviesWatchedVO> moviesWatchedList = null;
		
		if (StringUtil.isEmpty(userName)) {
			throw new ServiceException("Insufficient parameters...");
		}
		
		try {
			UsersBO usersBO = usersDAO.getByUserName(userName);
			
			if (usersBO == null) {
				throw new ServiceException("User not found...");
			}
			
			List<MoviesWatchedBO> boList = moviesWatchedDAO.getByUser(usersBO);
			
			if (boList == null || boList.size() == 0) {
				throw new ServiceException("No movies found for user...");
			}
			
			moviesWatchedList = MoviesWatchedMapper.fromBO(boList);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
		return moviesWatchedList;
	}
}
