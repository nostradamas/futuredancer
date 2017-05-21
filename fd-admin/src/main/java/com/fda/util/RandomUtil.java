package com.fda.util;

import java.util.Random;

/**
 * 随机码生成包
 */
public class RandomUtil {
	/**
	 * 生成随机字母数字
	 */
	public static String getRandomCharAndNum(int length) {
		String str = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			boolean b = random.nextBoolean();
			if (b) { // 字符�?
				int choice = random.nextBoolean() ? 65 : 97; // 取得65大写字母还是97小写字母
				str += (char) (choice + random.nextInt(26));
			} else { // 数字
				str += String.valueOf(random.nextInt(10));
			}
		}
		return str;
	}

	/**
	 * 生成随机数字
	 */
	public static String getRandomNum(int length) {
		String str = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			str += String.valueOf(random.nextInt(10));
		}
		return str;
	}

	/**
	 * 生成随机字母
	 */
	public static String getRandomChar(int length) {
		String str = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int choice = random.nextBoolean() ? 65 : 97; // 取得65大写字母还是97小写字母
			str += (char) (choice + random.nextInt(26));
		}
		return str;
	}
}
