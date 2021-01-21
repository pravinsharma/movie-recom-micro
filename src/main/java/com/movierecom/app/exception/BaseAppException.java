/**
 * 
 */
package com.movierecom.app.exception;

/**
 * @author PraveenKumar
 *
 */
public class BaseAppException extends Exception {
	private static final long serialVersionUID = 8776491638776852329L;

	public BaseAppException(String message) {
		super(message);
	}
	
	public BaseAppException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BaseAppException(Throwable cause) {
		super(cause);
	}
}