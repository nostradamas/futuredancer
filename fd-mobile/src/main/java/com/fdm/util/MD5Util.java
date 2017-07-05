package com.fdm.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
	public static String md5(String data) {
		return DigestUtils.md5Hex(data);
	}

	public static void main(String[] args) {
		System.out.println(md5("123456"));
	}

}
