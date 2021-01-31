/**
 * 
 */
package com.movierecom.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.movierecom.app.exception.BaseAppException;

/**
 * @author pravinsharma
 *
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	private static final Logger LOG = LoggerFactory.getLogger(JwtRequestFilter.class);
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		LOG.debug("Entering doFilterInternal...");
		
		String token = jwtTokenUtil.resolveToken(request);
	    try {
	      if (token != null && jwtTokenUtil.validateToken(token)) {
	        Authentication auth = jwtTokenUtil.getAuthentication(token);
	        SecurityContextHolder.getContext().setAuthentication(auth);
	      }
	    } catch (BaseAppException ex) {
	      //this is very important, since it guarantees the user is not authenticated at all
	      SecurityContextHolder.clearContext();
	      response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	      return;
	    }

	    filterChain.doFilter(request, response);
		
		/*
		try {
			String token = null;
			final String requestTokenHeader = request.getHeader(AppConstants.HEADER_STRING);

			if (requestTokenHeader != null && requestTokenHeader.startsWith(AppConstants.TOKEN_PREFIX)) {
				token = requestTokenHeader.substring(7);
				
				System.out.println("From header: " + token);
				System.out.println(", test: "
						+ jwtTokenUtil.validateToken(requestTokenHeader, "admin"));
				
				if(jwtTokenUtil.validateToken(requestTokenHeader)) {
					Authentication auth = jwtTokenUtil.getAuthentication(token);
			        SecurityContextHolder.getContext().setAuthentication(auth);
					// response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			        // return;
				}
			}
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
	        return;
		}
		
		filterChain.doFilter(request, response); */
		LOG.debug("Exiting doFilterInternal...");
	}

}
