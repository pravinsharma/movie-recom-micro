/**
 * 
 */
package com.movierecom.app.util;

import java.io.UnsupportedEncodingException;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.movierecom.app.exception.CodecException;

/**
 * @author pravinsharma
 *
 */
public class CodecUtil {
	private static BasicTextEncryptor EnD = new BasicTextEncryptor();
	
	static {
		EnD.setPassword(getEnD());
	}
	
	public static String decode(String encodedString) throws CodecException {
		String decodedString = null;
		
		try {
			decodedString = EnD.decrypt(encodedString);
		} catch (Exception e) {
			throw new CodecException(e);
		}
		
		return decodedString;
	}
	
	public static String encode(String normalString) throws CodecException {
		String encodedString = null;
		
		try {
			encodedString = EnD.encrypt(normalString);
		} catch (Exception e) {
			throw new CodecException(e);
		}
		
		return  encodedString;
	}
	
	public static boolean equals(String inputString, String encodedString) throws CodecException {
		return decode(encodedString).equals(inputString);
	}
	
	public static void main(String[] args) throws CodecException, UnsupportedEncodingException {
		String str = "admin";
		
		System.out.println(CodecUtil.encode(str));
		System.out.println(new BCryptPasswordEncoder().encode(str));
	}
	
	private static String getEnD() {
		String enc = "";
		
		enc += (char)((int)'i' + 2);
		enc += (char)((int)'e' + 4);
		enc += Character.toUpperCase('l');
		enc += (char)((int)'p' - 1);
		enc += (char)((int)'g' - ('a' - 'A'));
		enc += 'r';
		enc += (char)((int)'e' - 5);
		enc += (char)((int)'p' - 4);
		enc += "" + (100 + 600 + 'A' - 14);
		enc += '@';
		enc += '('
			+ ')'
			+ ';';
		
		return enc;
	}
}