/**
 * 
 */
package com.movierecom.app.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movierecom.app.users.bean.bo.SessionBO;

/**
 * @author pravinsharma
 *
 */
@Repository
public interface SessionRepository extends JpaRepository<SessionBO, Long> {

}
