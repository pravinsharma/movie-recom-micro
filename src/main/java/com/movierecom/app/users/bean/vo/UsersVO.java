/**
 * 
 */
package com.movierecom.app.users.bean.vo;

import java.util.Date;

import com.movierecom.app.bean.vo.IBaseVO;

/**
 * @author pravinsharma
 *
 */
public class UsersVO implements IBaseVO {
	private String username;
	
	private String password;
	
	private Date dated;

	public UsersVO() {
		super();
	}

	public UsersVO(String username, String password, Date dated) {
		super();
		this.username = username;
		this.password = password;
		this.dated = dated;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 * @return 
	 */
	public UsersVO setUsername(String username) {
		this.username = username;
		
		return this;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 * @return 
	 */
	public UsersVO setPassword(String password) {
		this.password = password;
		
		return this;
	}

	/**
	 * @return the dated
	 */
	public Date getDated() {
		return dated;
	}

	/**
	 * @param dated the dated to set
	 * @return 
	 */
	public UsersVO setDated(Date dated) {
		this.dated = dated;
		
		return this;
	}

	public UsersVO build() {
		return new UsersVO(username, password, dated);
	}
	
	public static UsersVO builder() {
		return new UsersVO();
	}
}
