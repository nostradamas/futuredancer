package com.fdw.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


/**
 * App工具
 */
public class AppTextUtil {

	/**
	 * 获取token
	 */
	public static String getToken(String userId) {
		String value = System.currentTimeMillis() + "-" + userId + "-" + RandomUtil.getRandomCharAndNum(6);
		return MD5Util.md5(value);
	}

	/**
	 * 获取文件key
	 */
	public static String getFileKey() {
		return DateUtil.getDate("yyyyMMdd") + System.currentTimeMillis() + RandomUtil.getRandomCharAndNum(12);
	}
	
	public static String getNewsCode(){
		Long time = System.currentTimeMillis();
		return time.toString().substring(3) + RandomUtil.getRandomCharAndNum(4);
	}
	
	/**
	 * 获取数据库关键字，Guuid
	 */
	public static String getPrimaryKey() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 获取订单编号
	 */
	public static String getOrderNo() {
		return DateUtil.getDate("yyyyMMddHHmmss") + UUID.randomUUID().toString().substring(0, 16);
	}

	/**
	 * 获取消费�?
	 */
	public static String getConsumerCode() {
		return DateUtil.getDate("yyyyMMddHHmmss") + UUID.randomUUID().toString().replace("-", "").substring(0, 16);
	}

	/**
	 * 获取商户订单�?
	 */
	public static String getBillNo(String mch_id) {
		return mch_id + DateUtil.getDate("yyyyMMdd") + RandomUtil.getRandomNum(10);
	}

	/**
	 * 获取ip地址
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 获取头像
	 * 
	 * @param imgPath
	 * @param logo
	 * @return
	 */
	public static String getLogo(String imgPath, String logo) {
		if (logo == null || !logo.contains("http://"))
			logo = imgPath + "/get/key/" + logo;
		return logo;
	}

	/**
	 * 获取图片地址
	 * 
	 * @param imgPath
	 * @param key
	 * @return
	 */
	public static String getImage(String imgPath, String key) {
		if (key == null || !key.contains("http://"))
			key = imgPath + "/get/key/" + key;
		return key;
	}

	public static String getCompanyName(String companyName) {
		return StringUtil.checkEmpty(companyName) ? "启动俱乐�?" : companyName;
	}
	
	public static void main(String[] args) {
		String key = getPrimaryKey();
		System.out.println(key);
//		for(int i = 0;i < 30; i++ ){
//			String k = getNewsCode();
//			
//			System.out.println(k);
//		}
	}
}
