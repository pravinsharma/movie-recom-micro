/**
 * 
 */
package com.movierecom.app.session.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.session.bean.bo.SessionBO;
import com.movierecom.app.session.repository.SessionRepository;
import com.movierecom.app.users.bean.bo.UsersBO;

/**
 * @author pravinsharma
 *
 */
@Component
public class SessionDAO implements ISessionDAO {
	private static final Logger LOG = LoggerFactory.getLogger(SessionDAO.class);
	
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
	
	public SessionBO getByUserName(UsersBO usersBO) throws DAOException {
		SessionBO sessionBO = null;
		
		try {
			sessionBO = repository.findTopByUserAndEndedatIsNullOrderByStartedatDesc(usersBO);
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
