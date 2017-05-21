package com.fda.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 字符串处理工具类
 */
public class CookieUtil {
	/**
	 * 根据名字获取cookie
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = readCookieMap(request);
		if (cookieMap.containsKey(name)) {
			return (Cookie) cookieMap.get(name);
		}
		return null;
	}

	/**
	 * 将cookie封装到Map里面
	 */
	public static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	/**
	 * 设置cookie
	 */
	public static Cookie setCookie(HttpServletResponse response, String key, String value, int expireTime) {
		Cookie cookie = new Cookie(key, value);//
		// 创建并实例化token对象
		cookie.setMaxAge(expireTime);
		// 设置cookie有效期为30分钟
		cookie.setPath("/");
		response.addCookie(cookie);
		return cookie;
	}

	/**
	 * 设置cookie
	 */
	public static Cookie setCookie(HttpServletResponse response, String key, String value) {
		return setCookie(response, key, value, 60 * 30);
	}
}
