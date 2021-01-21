/**
 * 
 */
package com.movierecom.app.users.dao;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.users.bean.bo.SessionBO;

/**
 * @author pravinsharma
 *
 */
public interface ISessionDAO {
	public SessionBO getById(Long id) throws DAOException;
	
	public void save(SessionBO session) throws DAOException;
}
