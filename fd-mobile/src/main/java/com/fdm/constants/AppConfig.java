package com.fdm.constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author 车库互联网+ 2016年7月27日
 */
public class AppConfig {
	private static Logger logger = Logger.getLogger(AppConfig.class);

	private String SERVER_PATH = "";
	private String SERVER_IP = "";
	private String SERVER_IMAGE_DIR = "";
	private String SERVER_IMAGE_PATH = "";

	private String QINIU_IMGAGE_URL = null;

	private static final String FUTURE_DANCER_CONFIGE_FILE = "/futuredancer.properties";
	private static AppConfig config = new AppConfig();

	public AppConfig() {
		Properties properties = new Properties();
		InputStream inStream = this.getClass().getResourceAsStream(FUTURE_DANCER_CONFIGE_FILE);
		if (inStream == null) {
			logger.error("根目录下找不到futuredancer.properties文件");
			return;
		}
		try {
			properties.load(inStream);
			this.SERVER_PATH = properties.getProperty("server.path");
			this.SERVER_IP = properties.getProperty("server.ip");
			this.SERVER_IMAGE_DIR = properties.getProperty("server.image_dir");
			this.SERVER_IMAGE_PATH = properties.getProperty("server.image_path");
			this.QINIU_IMGAGE_URL = properties.getProperty("server.qiniu_img_url");
		} catch (IOException e) {
			logger.error("load futuredancer.properties error,class 根目录下找不到文件xwbwlkj.properties文件");
			e.printStackTrace();
		}
		logger.info("load futuredancer.properties success");
	}

	public static AppConfig instance() {
		synchronized (AppConfig.class) {
			if (config == null)
				config = new AppConfig();
			return config;
		}
	}

	public String getSERVER_PATH() {
		return SERVER_PATH;
	}

	public void setSERVER_PATH(String sERVER_PATH) {
		SERVER_PATH = sERVER_PATH;
	}

	public String getSERVER_IP() {
		return SERVER_IP;
	}

	public void setSERVER_IP(String sERVER_IP) {
		SERVER_IP = sERVER_IP;
	}

	public String getSERVER_IMAGE_DIR() {
		return SERVER_IMAGE_DIR;
	}

	public void setSERVER_IMAGE_DIR(String sERVER_IMAGE_DIR) {
		SERVER_IMAGE_DIR = sERVER_IMAGE_DIR;
	}

	public String getSERVER_IMAGE_PATH() {
		return SERVER_IMAGE_PATH;
	}

	public void setSERVER_IMAGE_PATH(String sERVER_IMAGE_PATH) {
		SERVER_IMAGE_PATH = sERVER_IMAGE_PATH;
	}

	public String getQINIU_IMGAGE_URL() {
		return QINIU_IMGAGE_URL;
	}

}
