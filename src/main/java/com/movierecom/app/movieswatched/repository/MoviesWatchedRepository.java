/**
 * 
 */
package com.movierecom.app.movieswatched.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movierecom.app.movieswatched.bean.bo.MoviesWatchedBO;
import com.movierecom.app.users.bean.bo.UsersBO;

/**
 * @author pravinsharma
 *
 */
@Repository
public interface MoviesWatchedRepository extends JpaRepository<MoviesWatchedBO, Long> {
	public List<MoviesWatchedBO> getByUsers(UsersBO users);
}
