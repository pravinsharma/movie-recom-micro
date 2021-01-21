package com.movierecom.app.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.movierecom.app.exception.CodecException;
import com.movierecom.app.users.bean.vo.UsersVO;

public class TokenUtil {
	private static final Logger LOG = LoggerFactory.getLogger(TokenUtil.class);
	
	private static final String TOKEN_FORMAT = "{0}~{1}"; //username~timestamp
	
	public static String getToken(String username) throws CodecException {
		LOG.info("Entering encryptToken..., username: " + username);
		String token = null;
		
		token = CodecUtil.encode(StringUtil.format(TOKEN_FORMAT, username, "" + new Date().getTime()));
		
		LOG.info("Exiting encryptToken..., token: " + token);
		return token;
	}
	
	public static boolean isTokenValid(String tokenEncrypted) throws CodecException {
		LOG.info("Entering isTokenValid..., tokenEncrypted: " + tokenEncrypted);
		String []decodedArr = null;
		
		if(StringUtil.isEmpty(tokenEncrypted))
			return false;
		
		decodedArr = CodecUtil.decode(tokenEncrypted.replaceAll(" ", "+")).split("~");
		if(decodedArr.length!=2)
			return false;
		
		try {
			new Date(Long.parseLong(decodedArr[1], 10));
		} catch (NumberFormatException e) {
			return false;
		}
		
		LOG.info("Exiting isTokenValid...");
		return true;
	}
	
	public static UsersVO getUser(String token) throws CodecException {
		LOG.info("Entering decryptToken..., token: " + token);
		String []decodedArr = null;
		UsersVO user = null;
		
		if(StringUtil.isEmpty(token))
			throw new CodecException("No input...");
		
		decodedArr = CodecUtil.decode(token).split("~");
		if(decodedArr.length!=2)
			throw new CodecException("Improper format...");
		
		try {
			user = new UsersVO(decodedArr[0], null, new Date(Long.parseLong(decodedArr[1], 10)));
		} catch (NumberFormatException e) {
			throw new CodecException(e.getMessage(), e);
		}
		
		LOG.info("Exiting decryptToken..., user: " + user);
		return user;
	}
}
