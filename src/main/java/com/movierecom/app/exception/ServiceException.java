/**
 * 
 */
package com.movierecom.app.exception;

import com.movierecom.app.exception.BaseAppException;

/**
 * @author pravinsharma
 *
 */
public class ServiceException extends BaseAppException {
	private static final long serialVersionUID = -1462341382289218989L;

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
