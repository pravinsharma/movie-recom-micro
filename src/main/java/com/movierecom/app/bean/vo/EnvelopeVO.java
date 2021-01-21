/**
 * 
 */
package com.movierecom.app.bean.vo;

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
public class EnvelopeVO<T extends IPayloadVO> {
	private int code;
	
	private String message;
	
	private T payload;
}
