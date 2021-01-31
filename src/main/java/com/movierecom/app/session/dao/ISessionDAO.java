/**
 * 
 */
package com.movierecom.app.session.dao;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.session.bean.bo.SessionBO;
import com.movierecom.app.users.bean.bo.UsersBO;

/**
 * @author pravinsharma
 *
 */
public interface ISessionDAO {
	public SessionBO getById(Long id) throws DAOException;
	
	public SessionBO getByUserName(UsersBO usersBO) throws DAOException;
	
	public void save(SessionBO session) throws DAOException;
}
