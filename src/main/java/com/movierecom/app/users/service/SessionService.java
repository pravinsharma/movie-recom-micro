/**
 * 
 */
package com.movierecom.app.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movierecom.app.exception.CodecException;
import com.movierecom.app.exception.DAOException;
import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.users.bean.bo.DataDictBO;
import com.movierecom.app.users.bean.bo.SessionBO;
import com.movierecom.app.users.bean.bo.UsersBO;
import com.movierecom.app.users.bean.mapper.SessionMapper;
import com.movierecom.app.users.bean.vo.SessionVO;
import com.movierecom.app.users.bean.vo.UsersVO;
import com.movierecom.app.users.dao.IDataDictDAO;
import com.movierecom.app.users.dao.ISessionDAO;
import com.movierecom.app.users.dao.IUsersDAO;
import com.movierecom.app.util.CodecUtil;
import com.movierecom.app.util.TokenUtil;

/**
 * @author pravinsharma
 *
 */
@Service
public class SessionService implements ISessionService {
	
	@Autowired
	IUsersDAO usersDAO;
	
	@Autowired
	ISessionDAO sessionDAO;
	
	@Autowired
	IDataDictDAO dataDictDAO;
	
	public SessionVO login(UsersVO users) throws ServiceException {
		if (users == null) {
			return null;
		}
		
		try {
			UsersBO usersBO = usersDAO.getByUserName(users.getUsername());
			
			if (usersBO != null && CodecUtil.equals(users.getPassword(), usersBO.getPasswd())) {
				System.out.println("matches...");
				
				DataDictBO dataDictBO = dataDictDAO.getByName("LOGIN");

				SessionBO sessionBO = new SessionBO(
						usersBO, dataDictBO,
						TokenUtil.getToken(users.getUsername()));
				
				sessionDAO.save(sessionBO);
				
				return SessionMapper.fromBO(sessionBO);
			} else {
				System.out.println("no match...");
			}
		} catch (CodecException | DAOException e) {
			throw new ServiceException(e);
		}
		
		return null;
	}
	
	public SessionVO logout(String token) throws ServiceException {
		SessionBO sessionBO = null;
		
		if (token == null) {
			return null;
		}
		
		try {
			UsersVO users = TokenUtil.getUser(token);
			
			if (users == null) {
				throw new ServiceException("corrupted token...");
			}
			
			UsersBO usersBO = usersDAO.getByUserName(users.getUsername());
			
			if (usersBO == null) {
				throw new ServiceException("no user found by token...");
			}
			
			DataDictBO dataDictBO = dataDictDAO.getByName("LOGOUT");

			sessionBO = new SessionBO(
					usersBO, dataDictBO,
					TokenUtil.getToken(users.getUsername()));
			
			sessionDAO.save(sessionBO);
			sessionBO.setToken(null);
		} catch (CodecException | DAOException e) {
			throw new ServiceException(e);
		}
		
		return SessionMapper.fromBO(sessionBO);
	}
}
