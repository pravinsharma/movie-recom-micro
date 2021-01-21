/**
 * 
 */
package com.movierecom.app.users.bean.vo;

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
