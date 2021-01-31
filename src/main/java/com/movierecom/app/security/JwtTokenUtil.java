/**
 * 
 */
package com.movierecom.app.security;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.movierecom.app.exception.BaseAppException;
import com.movierecom.app.security.model.Role;
import com.movierecom.app.util.StringUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author pravinsharma
 *
 */
@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = 2005152927103926786L;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.validity}")
	private long jwtValidity;

	/*
	@ PostConstruct
	protected void init() {
		secret = Base64.getEncoder().encodeToString(secret.getBytes());
	} */

	/**
	 * Get username as subject
	 * 
	 * @param token
	 * @return
	 * @throws BaseAppException
	 */
	public String getUsername(String token) throws BaseAppException {
		if (StringUtil.isEmpty(token)) {
			throw new BaseAppException("Inputs are empty...");
		}
		
		return getClaim(token, Claims::getSubject);
	}

	/**
	 * Get expiry
	 * 
	 * @param token
	 * @return
	 * @throws BaseAppException
	 */
	public Date getExpiry(String token) throws BaseAppException {
		if (StringUtil.isEmpty(token)) {
			throw new BaseAppException("Inputs are empty...");
		}
		
		return getClaim(token, Claims::getExpiration);
	}

	/**
	 * Get claim
	 * 
	 * @param <T>
	 * @param token
	 * @param claimsResolver
	 * @return
	 * @throws BaseAppException
	 */
	public <T> T getClaim(String token, Function<Claims, T> claimsResolver) throws BaseAppException {
		if (StringUtil.isEmpty(token) || claimsResolver == null) {
			throw new BaseAppException("Inputs are empty...");
		}
		
		final Claims claims = getAllClaims(token);
		return (claims != null)? claimsResolver.apply(claims): null;
	}
    
	/**
	 * Gets all claim
	 * 
	 * @param token
	 * @return
	 */
	private Claims getAllClaims(String token) throws BaseAppException {
		if (StringUtil.isEmpty(token)) {
			throw new BaseAppException("Inputs are empty...");
		}
		
		Claims claims = null;System.out.println("secret: " + secret);
		
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return claims;
	}

	/**
	 * get token from header
	 * 
	 * @param req
	 * @return
	 */
	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		
		return null;
	}

	/**
	 * Check token expiry
	 * 
	 * @param token
	 * @return
	 */
	private Boolean isTokenExpired(String token) throws BaseAppException {
		if (StringUtil.isEmpty(token)) {
			throw new BaseAppException("Inputs are empty...");
		}
		
		return getExpiry(token).before(new Date());
	}

	/**
	 * Generate token for user
	 * 
	 * @param userDetails
	 * @return
	 * @throws BaseAppException 
	 */
	public String generateToken(String username, List<Role> roles) throws BaseAppException {
		if (StringUtil.isEmpty(username)) {
			throw new BaseAppException("Inputs are empty...");
		}
		
		// Map<String, Object> claims = new HashMap<>();
		// return doGenerateToken(claims, userDetails.getUsername());
		
		Claims claims = Jwts.claims().setSubject(username);
	    claims.put("auth", roles.stream()
	    		.map(s -> new SimpleGrantedAuthority(s.getAuthority()))
	    		.filter(Objects::nonNull)
	    		.collect(Collectors.toList()));

	    Date now = new Date();
	    Date validity = new Date(now.getTime() + jwtValidity * 1000);

		return Jwts
				.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(validity)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	/**
	 * Validate token against user details
	 * 
	 * @param token
	 * @param username
	 * @return
	 * @throws BaseAppException 
	 */
	public Boolean validateToken(String token, String username) throws BaseAppException {
		if (!StringUtil.isAllFull(token, username)) {
			throw new BaseAppException("Inputs are empty...");
		}
		
		final String _username = getUsername(token);
		return (username.equals(_username) && !isTokenExpired(token));
	}

	/**
	 * Validate token
	 * 
	 * @param token
	 * @return
	 * @throws BaseAppException
	 */
	public boolean validateToken(String token) throws BaseAppException {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
		} catch (JwtException | IllegalArgumentException e) {System.out.println("errr: " ); e.printStackTrace();
			throw new BaseAppException(e);
		}
		
		return true;
	}

	/**
	 * get auth token
	 * 
	 * @param token
	 * @return
	 * @throws UsernameNotFoundException
	 * @throws BaseAppException
	 */
	public Authentication getAuthentication(String token) throws UsernameNotFoundException, BaseAppException {
		UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
		
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	/*
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts
				.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtValidity * 1000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	} */
}
