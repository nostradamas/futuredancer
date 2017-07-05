package com.fdm.util;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @author 车库互联网+ 2016年10月25日
 * 
 */
public class QiniuUtil {

	Logger logger = Logger.getLogger(QiniuUtil.class);

	// 设置好账号的ACCESS_KEY和SECRET_KEY
	String ACCESS_KEY = "nHJ1mpcvBY-VljuZJL-tzEVqgmH0cvxh_hpaFoT3";
	String SECRET_KEY = "PBDdav11hH5qEH-EdM9Sen2ARAWFmu8Vneb5fwWc";
	// 要上传的空间
	String bucketname = "futuredancer";
	// 密钥配置
	Auth auth;
	// 创建上传对象
	UploadManager uploadManager;
	
	private static QiniuUtil instance;
	
	public static QiniuUtil getInstance(){
		synchronized (QiniuUtil.class) {
			if (instance==null) {
				instance = new QiniuUtil();
			}
			return instance;
		}
	}

	public QiniuUtil() {
		Configuration cfg = new Configuration(Zone.zone0());
		auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		uploadManager = new UploadManager(cfg);
	}
	
	// 覆盖上传
	public String getUpToken(){
		// <bucket>:<key>，表示只允许用户上传指定key的文件。在这种格式下文件默认允许“修改”，已存在同名资源则会被本次覆盖。
		return auth.uploadToken(bucketname);
	}
	
	
	/**
	 * 上传文件
	 * 
	 * @param key
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public String upload(String key, byte[] data) {
		try {
			// 调用put方法上传，这里指定的key和上传策略中的key要一致
			Response res = uploadManager.put(data, key, getUpToken());
			// 打印返回的信息
			logger.info("upload qiniu server response body string is: " + res.bodyString());
			/*if (res.isOK() && res.isJson()) {
				JSONObject json = new JSONObject(res.bodyString());
				return json.getString("key");
			}*/
			//解析上传成功的结果
			DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
			logger.info("qiniu key "+putRet.key);
			logger.info("qiniu hash "+putRet.hash);
			return putRet.key;
			//}
		} catch (QiniuException e) {
			Response res = e.response;
			// 请求失败时打印的异常信息
			try {
				// 响应的文本信息
				logger.info("upload qiniu server response body string error is: " + res.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		return null;
	}

}
