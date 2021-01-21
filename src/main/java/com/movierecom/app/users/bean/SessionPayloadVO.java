/**
 * 
 */
package com.movierecom.app.users.bean;

import com.movierecom.app.bean.vo.IBaseVO;
import com.movierecom.app.bean.vo.IPayloadVO;

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
public class SessionPayloadVO implements IPayloadVO {
	private IBaseVO json;
}
