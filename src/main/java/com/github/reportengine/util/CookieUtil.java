package com.github.reportengine.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * 
 * @author badqiu
 *
 */
public class CookieUtil {
	private static String ARRAY_SEPERATOR = "\001";
	static String URL_ENCODE = "UTF-8";
	
	private final static Logger logger = LoggerFactory.getLogger(CookieUtil.class);
	
	public static void saveParamInotCookie(Map<String,Object> param, HttpServletResponse resp,String cookieNamePrefix,int maxAge) {
		Assert.notNull(cookieNamePrefix,"cookieNamePrefix must be not empty");
		
		for(String key : param.keySet()) {
			Object value = param.get(key);
//			if(value == null) {
//				continue;
//			}
			
			String strValue = null;
			if(value instanceof String) {
				strValue = (String)value;
			}else {
				strValue = StringUtils.join((Object[])value,ARRAY_SEPERATOR);
			}
			
//			if(StringUtils.isBlank(strValue)) {
//				continue;
//			}
			
			Cookie cookie = null;
			try {
				cookie = new Cookie(cookieNamePrefix+key,URLEncoder.encode(strValue, URL_ENCODE));
			} catch (UnsupportedEncodingException e) {
				logger.error("cookie encode error,", e);
			}
			cookie.setMaxAge(maxAge);
			cookie.setPath("/");
//				cookie.setMaxAge(-1); //浏览器进程生效
			resp.addCookie(cookie);
		}
	}
	
	/**
	 * 清除所有 cookie
	 */
	public static void cleanAllCookie(HttpServletRequest resq,HttpServletResponse resp,String cookieNamePrefix) {
		Assert.notNull(cookieNamePrefix,"cookieNamePrefix must be not empty");
		
		Cookie[] cookies = resq.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().startsWith(cookieNamePrefix)) {
					c.setValue(null);
					c.setPath("/");
					c.setMaxAge(0);
					resp.addCookie(c);
				}
			}
		}
	}
	
	public static Map getCookieMap(HttpServletRequest req,String cookieNamePrefix) {
		Assert.notNull(cookieNamePrefix,"cookieNamePrefix must be not empty");
		
		Map map = new HashMap();
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				String cookieName = c.getName();
				if(cookieName.startsWith(cookieNamePrefix)) {
					String key = cookieName.substring(cookieNamePrefix.length());
					String value = null;
					
					if(StringUtils.isNotBlank(c.getValue())) {
						try {
							value = URLDecoder.decode(c.getValue(), URL_ENCODE);
						} catch (UnsupportedEncodingException e) {
							logger.error("cookie decode error,",e);
						}
					}
					
					if(StringUtils.isNotBlank(value)) {
						if(StringUtils.contains(value, ARRAY_SEPERATOR)) {
							String[] values = StringUtils.split(value,ARRAY_SEPERATOR);
							map.put(key, values);
						}else {
							map.put(key,value);
						}
					}
				}
				
			}
		}
		return map;
	}
	
}
