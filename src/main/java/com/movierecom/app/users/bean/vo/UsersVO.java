/**
 * 
 */
package com.movierecom.app.users.bean.vo;

import java.util.Date;

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
public class UsersVO {
	private String username;
	
	private String password;
	
	private Date dated;
}
