/**
 * 
 */
package com.movierecom.app.exception;

import com.movierecom.app.exception.BaseAppException;

/**
 * @author pravinsharma
 *
 */
public class DAOException extends BaseAppException {
	private static final long serialVersionUID = -1462341382289218989L;

	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DAOException(Throwable cause) {
		super(cause);
	}
}
