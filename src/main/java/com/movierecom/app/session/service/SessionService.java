/**
 * 
 */
package com.movierecom.app.session.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movierecom.app.datadict.bean.bo.DataDictBO;
import com.movierecom.app.datadict.dao.IDataDictDAO;
import com.movierecom.app.exception.BaseAppException;
import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.security.JwtTokenUtil;
import com.movierecom.app.security.model.Role;
import com.movierecom.app.session.bean.bo.SessionBO;
import com.movierecom.app.session.bean.mapper.SessionMapper;
import com.movierecom.app.session.bean.vo.SessionVO;
import com.movierecom.app.session.dao.ISessionDAO;
import com.movierecom.app.users.bean.bo.UsersBO;
import com.movierecom.app.users.bean.vo.UsersVO;
import com.movierecom.app.users.dao.IUsersDAO;
import com.movierecom.app.util.StringUtil;

/**
 * @author pravinsharma
 *
 */
@Service
public class SessionService implements ISessionService {
	private static final Logger LOG = LoggerFactory.getLogger(SessionService.class);
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	IUsersDAO usersDAO;
	
	@Autowired
	ISessionDAO sessionDAO;
	
	@Autowired
	IDataDictDAO dataDictDAO;
	
	public SessionVO login(UsersVO users) throws ServiceException {
		SessionVO session = null;
		
		if (users == null) {
			return null;
		}
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
			
			UsersBO usersBO = usersDAO.getByUserName(users.getUsername());
			
			if (usersBO != null && 
					new BCryptPasswordEncoder().matches(users.getPassword(), usersBO.getPasswd())) {
				
				SessionBO sessionBO = sessionDAO.getByUserName(usersBO);
				
				if (sessionBO == null) {
					DataDictBO dataDictBO = dataDictDAO.getByName("SESSION");
	
					sessionBO = new SessionBO(
							usersBO, dataDictBO,
							jwtTokenUtil.generateToken(users.getUsername(), Collections.emptyList()));
					
					sessionDAO.save(sessionBO);
				}
				
				session = SessionMapper.fromBO(sessionBO);
			} else {
				LOG.info("no match...");
			}
		} catch (BaseAppException e) {
			throw new ServiceException(e);
		}
		
		return session;
	}
	
	public SessionVO logout(String token) throws ServiceException {
		SessionVO session = null;
		
		if (token == null) {
			return null;
		}
		
		try {
			String username = jwtTokenUtil.getUsername(token);
			
			if (StringUtil.isEmpty(username)) {
				throw new ServiceException("corrupted token...");
			}
			
			UsersBO usersBO = usersDAO.getByUserName(username);
			
			if (usersBO == null) {
				throw new ServiceException("no user found by token...");
			}
			
			SessionBO sessionBO = sessionDAO.getByUserName(usersBO);
			
			if (sessionBO == null) {
				throw new ServiceException("no active session for user...");
			}
			
			if (!token.equals(sessionBO.getToken())) {
				throw new ServiceException("token mismatch...");
			}
			
			sessionBO.setEndedat(LocalDateTime.now());
			
			sessionDAO.save(sessionBO);
			sessionBO.setToken(null);
			
			session = SessionMapper.fromBO(sessionBO);
		} catch (BaseAppException e) {
			throw new ServiceException(e);
		}
		
		return session;
	}
}
