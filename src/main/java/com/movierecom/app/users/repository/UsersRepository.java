/**
 * 
 */
package com.movierecom.app.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movierecom.app.users.bean.bo.UsersBO;

/**
 * @author pravinsharma
 *
 */
@Repository
public interface UsersRepository extends JpaRepository<UsersBO, Long> {
	UsersBO getByUsername(String username);
}
