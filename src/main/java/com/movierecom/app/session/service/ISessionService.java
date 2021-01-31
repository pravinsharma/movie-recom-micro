/**
 * 
 */
package com.movierecom.app.session.service;

import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.session.bean.vo.SessionVO;
import com.movierecom.app.users.bean.vo.UsersVO;

/**
 * @author pravinsharma
 *
 */
public interface ISessionService {
	public SessionVO login(UsersVO users) throws ServiceException;
	
	public SessionVO logout(String token) throws ServiceException;
}
