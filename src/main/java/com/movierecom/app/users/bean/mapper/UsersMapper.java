/**
 * 
 */
package com.movierecom.app.users.bean.mapper;

import com.movierecom.app.users.bean.bo.UsersBO;
import com.movierecom.app.users.bean.vo.UsersVO;

/**
 * @author pravinsharma
 *
 */
public class UsersMapper {
	public static UsersVO fromBO(UsersBO bo) {
		return bo!=null? new UsersVO(bo.getUsername(), bo.getPasswd(), null): null;
	}
	
	public static UsersBO toBO(UsersVO vo) {
		return vo!=null? new UsersBO(vo.getUsername(), vo.getPassword()): null;
	}
}
