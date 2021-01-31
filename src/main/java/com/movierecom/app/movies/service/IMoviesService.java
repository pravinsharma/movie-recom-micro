/**
 * 
 */
package com.movierecom.app.movies.service;

import java.util.List;

import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.movies.bean.vo.MoviesVO;

/**
 * @author pravinsharma
 *
 */
public interface IMoviesService {
	public MoviesVO getById(Long id) throws ServiceException;
	
	public List<MoviesVO> getByName(String name) throws ServiceException;
	
	public List<MoviesVO> getByNameAndYear(String name, String year) throws ServiceException;
	
	public List<MoviesVO> getByNameAndGenre(String name, String genre) throws ServiceException;
	
	public List<MoviesVO> getByYear(String year) throws ServiceException;
	
	public List<MoviesVO> getByYearAndGenre(String year, String genre) throws ServiceException;
	
	public List<MoviesVO> getByGenre(String genre) throws ServiceException;
	
	public void save(MoviesVO movies) throws ServiceException;
}
