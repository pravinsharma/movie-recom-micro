/**
 * 
 */
package com.movierecom.app.util;

/**
 * @author pravinsharma
 *
 */
public interface AppConstants {
	String SECRET = "SECRET_KEY";
	long EXPIRATION_TIME = 900_000; // 15 mins
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Authorization";
	String SIGN_UP_URL = "/api/user/auth";
}
