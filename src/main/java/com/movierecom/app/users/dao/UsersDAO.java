/**
 * 
 */
package com.movierecom.app.users.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.users.bean.bo.UsersBO;
import com.movierecom.app.users.repository.UsersRepository;

/**
 * @author pravinsharma
 *
 */
@Component
public class UsersDAO implements IUsersDAO {
	
	@Autowired
	UsersRepository repository;
	
	public UsersBO getById(Long id) throws DAOException {
		UsersBO usersBO = null;
		
		try {
			usersBO = repository.getOne(id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return usersBO;
	}

	@Override
	public UsersBO getByUserName(String username) throws DAOException {
		UsersBO usersBO = null;
		
		try {
			usersBO = repository.getByUsername(username);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return usersBO;
	}
}
