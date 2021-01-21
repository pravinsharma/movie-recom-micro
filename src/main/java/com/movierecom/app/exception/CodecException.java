/**
 * 
 */
package com.movierecom.app.exception;

/**
 * @author PraveenKumar
 *
 */
public class CodecException extends BaseAppException {
	private static final long serialVersionUID = 874849737884718240L;

	public CodecException(String message) {
		super(message);
	}
	
	public CodecException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CodecException(Throwable cause) {
		super(cause);
	}
}