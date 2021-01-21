/**
 * 
 */
package com.movierecom.app.users.dao;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.users.bean.bo.UsersBO;

/**
 * @author pravinsharma
 *
 */
public interface IUsersDAO {
	public UsersBO getById(Long id) throws DAOException;
	
	public UsersBO getByUserName(String username) throws DAOException;
}
