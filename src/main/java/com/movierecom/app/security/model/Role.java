/**
 * 
 */
package com.movierecom.app.security.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author pravinsharma
 *
 */
public enum Role implements GrantedAuthority {
	ROLE_ADMIN, ROLE_CLIENT;

	public String getAuthority() {
		return name();
	}
}
