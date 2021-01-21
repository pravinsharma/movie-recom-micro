/**
 * 
 */
package com.movierecom.app.bean.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pravinsharma
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenVO implements IBaseVO {
	private String username;
	
	private Date dated;
}
