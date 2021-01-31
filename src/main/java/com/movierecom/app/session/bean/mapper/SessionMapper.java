/**
 * 
 */
package com.movierecom.app.session.bean.mapper;

import com.movierecom.app.session.bean.bo.SessionBO;
import com.movierecom.app.session.bean.vo.SessionVO;

/**
 * @author pravinsharma
 *
 */
public class SessionMapper {
	public static SessionVO fromBO(SessionBO bo) {
		return bo!=null? new SessionVO(bo.getUser().getUsername(), bo.getActivity().getName(), bo.getToken()): null;
	}
	
	public static SessionBO toBO(SessionVO vo) {
		return vo!=null? new SessionBO(vo.getUsername(), vo.getActivity(), vo.getToken()): null;
	}
}
