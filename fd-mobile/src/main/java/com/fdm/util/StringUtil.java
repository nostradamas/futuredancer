package com.fdm.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * 字符串处理工具类
 */
public class StringUtil {
	/**
	 * �?查是否为�?
	 */
	public static boolean checkEmpty(String value) {
		return value == null || value.trim().length() <= 0;
	}

	/**
	 * 格式化字符串
	 */
	public static String formatStr(String format, Object... values) {
		if (format == null)
			format = "";
		return String.format(format, values);
	}

	/**
	 * 格式化为字符�?
	 */
	public static String toString(Object value, String def) {
		return value == null ? def : String.valueOf(value);
	}

	/***
	 * 合并字节数组
	 */
	public static byte[] mergeArray(byte[]... a) {
		// 合并完之后数组的总长�?
		int index = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i].length;
		}
		byte[] result = new byte[sum];
		for (int i = 0; i < a.length; i++) {
			int lengthOne = a[i].length;
			if (lengthOne == 0) {
				continue;
			}
			// 拷贝数组
			System.arraycopy(a[i], 0, result, index, lengthOne);
			index = index + lengthOne;
		}
		return result;
	}

	/**
	 * 两个数组是否有相同字�?
	 */
	public static boolean equals(String[] parent, String[] child) {
		for (String p : parent) {
			for (String c : child) {
				if (c.equals(p))
					return true;
			}
		}

		return false;
	}

	/**
	 * stream to string
	 */
	public static String streamToString(InputStream is) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = -1;
		try {
			while ((i = is.read()) != -1) {
				baos.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toString();
	}
	
	public static String decode(String fileName) {
		String str = null;
		try {
			str = java.net.URLEncoder.encode(fileName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

}
