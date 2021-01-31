/**
 * 
 */
package com.movierecom.app.movieswatched.bean.vo;

import java.time.LocalDateTime;

import com.movierecom.app.bean.vo.IBaseVO;
import com.movierecom.app.movies.bean.vo.MoviesVO;
import com.movierecom.app.users.bean.vo.UsersVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pravinsharma
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesWatchedVO implements IBaseVO {
	private MoviesVO movies;
	
	private UsersVO users;
	
	private LocalDateTime accessed;
}
