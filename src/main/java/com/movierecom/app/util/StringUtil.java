/**
 * 
 */
package com.movierecom.app.util;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @author pravinsharma
 *
 */
public class StringUtil {
	public static boolean isEmpty(String str) {
		if(str==null || str.trim().length()==0)
			return true;
		
		return false;
	}
	
	public static String toStr(Object obj) {
		if(obj==null)
			return null;
		
		if(obj.toString().trim().length()==0)
			return null;
		
		return obj.toString();
	}
	
	public static String toStr(Object obj, String defaultValue) {
		String str = toStr(obj);
		
		return (str!=null?str:defaultValue);
	}
	
	public static String toStr(Object[] objs) {
		if(objs==null || objs.length==0)
			return null;
		
		return Arrays.toString(objs);
	}
	
	public static String format(String str, String... values) {
		return new MessageFormat(str).format(values);
	}
}
