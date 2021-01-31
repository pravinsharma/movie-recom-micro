/**
 * 
 */
package com.movierecom.app.session.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movierecom.app.session.bean.bo.SessionBO;
import com.movierecom.app.users.bean.bo.UsersBO;

/**
 * @author pravinsharma
 *
 */
@Repository
public interface SessionRepository extends JpaRepository<SessionBO, Long> {
	// SessionBO findTopByUserOrderByStartedatDesc(UsersBO users);
	SessionBO findTopByUserAndEndedatIsNullOrderByStartedatDesc(UsersBO users);
}
