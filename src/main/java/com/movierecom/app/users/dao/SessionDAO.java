/**
 * 
 */
package com.movierecom.app.users.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.users.bean.bo.SessionBO;
import com.movierecom.app.users.repository.SessionRepository;

/**
 * @author pravinsharma
 *
 */
@Component
public class SessionDAO implements ISessionDAO {
	
	@Autowired
	SessionRepository repository;
	
	public SessionBO getById(Long id) throws DAOException {
		SessionBO sessionBO = null;
		
		try {
			sessionBO = repository.getOne(id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return sessionBO;
	}
	
	public void save(SessionBO sessionBO) throws DAOException {
		try {
			repository.save(sessionBO);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}
