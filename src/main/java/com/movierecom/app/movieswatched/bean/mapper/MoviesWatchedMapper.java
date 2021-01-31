/**
 * 
 */
package com.movierecom.app.movieswatched.bean.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.movierecom.app.movies.bean.mapper.MoviesMapper;
import com.movierecom.app.movieswatched.bean.bo.MoviesWatchedBO;
import com.movierecom.app.movieswatched.bean.vo.MoviesWatchedVO;
import com.movierecom.app.users.bean.mapper.UsersMapper;

/**
 * @author pravinsharma
 *
 */
public class MoviesWatchedMapper {
	public static MoviesWatchedVO fromBO(MoviesWatchedBO bo) {
		return bo!=null? new MoviesWatchedVO(
				MoviesMapper.fromBO(bo.getMovies()),
				UsersMapper.fromBO(bo.getUsers()),
				bo.getCreatedat()): null;
	}
	
	public static List<MoviesWatchedVO> fromBO(List<MoviesWatchedBO> boList) {
		if (boList == null || boList.size() == 0) {
			return null;
		}
		
		return boList.stream()
				.map(m -> fromBO(m))
				.collect(Collectors.toList());
	}
	
	public static MoviesWatchedBO toBO(MoviesWatchedVO vo) {
		return vo!=null? new MoviesWatchedBO(
				MoviesMapper.toBO(vo.getMovies()),
				UsersMapper.toBO(vo.getUsers())): null;
	}
}