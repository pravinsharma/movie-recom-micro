/**
 * 
 */
package com.movierecom.app.movies.bean.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.movierecom.app.genre.bean.bo.GenreBO;
import com.movierecom.app.movies.bean.bo.MoviesBO;
import com.movierecom.app.movies.bean.vo.MoviesVO;

/**
 * @author pravinsharma
 *
 */
public class MoviesMapper {
	public static MoviesVO fromBO(MoviesBO bo) {
		return bo!=null? new MoviesVO(bo.getName(), bo.getYear(),
				bo.getGenre().getName(), bo.getSummary()): null;
	}
	
	public static List<MoviesVO> fromBO(List<MoviesBO> boList) {
		return boList!=null?
				boList.stream()
				.map(m -> 
					new MoviesVO(m.getName(), m.getYear(),
							m.getGenre().getName(), m.getSummary())
					)
				.collect(Collectors.toList()): null;
	}
	
	public static MoviesBO toBO(MoviesVO vo) {
		return vo!=null? new MoviesBO(vo.getName(), vo.getYear(),
				new GenreBO(vo.getGenre()), vo.getSummary()): null;
	}
}
