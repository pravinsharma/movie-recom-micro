/**
 * 
 */
package com.movierecom.app.exception;

/**
 * @author PraveenKumar
 *
 */
public class BaseSysException extends RuntimeException {
	private static final long serialVersionUID = -8730820351010581748L;

	public BaseSysException(String message) {
		super(message);
	}
	
	public BaseSysException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BaseSysException(Throwable cause) {
		super(cause);
	}
}