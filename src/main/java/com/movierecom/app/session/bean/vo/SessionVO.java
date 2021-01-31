/**
 * 
 */
package com.movierecom.app.session.bean.vo;

import com.movierecom.app.bean.vo.IBaseVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pravinsharma
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionVO implements IBaseVO {
	private String username;
	
	private String activity;
	
	private String token;
}
