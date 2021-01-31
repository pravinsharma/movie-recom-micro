/**
 * 
 */
package com.movierecom.app.movieswatched.service;

import java.util.List;

import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.movieswatched.bean.vo.MoviesWatchedVO;

/**
 * @author pravinsharma
 *
 */
public interface IMoviesWatchedService {
	public MoviesWatchedVO getById(Long id) throws ServiceException;
	
	public List<MoviesWatchedVO> getByUserName(String userName) throws ServiceException;
}
