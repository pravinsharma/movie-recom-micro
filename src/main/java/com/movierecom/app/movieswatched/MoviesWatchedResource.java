/**
 * 
 */
package com.movierecom.app.movieswatched;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movierecom.app.bean.vo.EnvelopeVO;
import com.movierecom.app.bean.vo.PayloadVO;
import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.movieswatched.bean.vo.MoviesWatchedVO;
import com.movierecom.app.movieswatched.service.IMoviesWatchedService;
import com.movierecom.app.users.bean.vo.UsersVO;

/**
 * @author pravinsharma
 *
 */
@RestController
public class MoviesWatchedResource {
	
	@Autowired
	IMoviesWatchedService moviesWatchedService;
	
	@PostMapping(value = "${spring.data.rest.base-path}/movie/watched")
	public ResponseEntity<EnvelopeVO<PayloadVO>> moviesWatched(@RequestBody UsersVO user) {
		System.out.println("user: " + user);
		List<MoviesWatchedVO> moviesWatchedList = null;
		
		try {
			moviesWatchedList = moviesWatchedService.getByUserName(user.getUsername());
		} catch (ServiceException e) {
			e.printStackTrace();
			
			return new ResponseEntity<EnvelopeVO<PayloadVO>>
				(new EnvelopeVO<PayloadVO>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null),
					HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<EnvelopeVO<PayloadVO>>
			(new EnvelopeVO<PayloadVO>(HttpStatus.OK.value(), "SUCCESS", 
					new PayloadVO(moviesWatchedList.toArray(new MoviesWatchedVO[moviesWatchedList.size()]))),
				HttpStatus.OK);
	}
}
