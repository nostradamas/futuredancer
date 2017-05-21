package com.fdw.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 文件上传工具�?
 *
 */
public class FileUploadUtil {
	/**
	 * 保存文件
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public static String saveFile(String fname, HttpServletRequest request) throws IllegalStateException, IOException{
		//转换成多部分request    
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
        //取得request中的�?有文件名  
        Iterator<String> iter = multiRequest.getFileNames(); 
        //重命名上传后的文件名  
        String fileName = fname + AppTextUtil.getFileKey() +"_";
        while(iter.hasNext()){  
            //取得上传文件  
            MultipartFile file = multiRequest.getFile(iter.next());  
            if(file != null){  
                //取得当前上传文件的文件名�?  
                String myFileName = file.getOriginalFilename();  
                //如果名称不为“�??,说明该文件存在，否则说明该文件不存在  
                if(myFileName.trim() !=""){  
                    System.out.println(myFileName);  
                   //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安�?
                    String savePath =  request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");
                    File upDir = new File(savePath);
        			if (!upDir.exists()) {
        				upDir.mkdirs();
        			}
        			fileName += file.getOriginalFilename();
                    String path = upDir.getPath() + File.separator + fileName;
                    File localFile = new File(path);  
                    file.transferTo(localFile);
                }  
            }  
        }
		return fileName;
	}
	
	/**
	 * 获取客户端浏览器类型、编码下载文件名
	 * 
	 * @param request
	 * @param fileName
	 * @return String
	 */
	public static String encodeFileName(HttpServletRequest request, String fileName) {
		String userAgent = request.getHeader("User-Agent");
		String rtn = "";
		try {
			System.out.println(fileName);
			String new_filename = URLEncoder.encode(fileName, "UTF-8");
			System.out.println(new_filename);
			// 如果没有UA，则默认使用IE的方式进行编码，因为毕竟IE还是占多数的
			rtn = new_filename;
			if (userAgent != null) {
				userAgent = userAgent.toLowerCase();
				// ie浏览器，ie11等版本的文件编码
				if(userAgent.contains("msie") || userAgent.contains("trident") || userAgent.contains("edge")){
					rtn = URLEncoder.encode(fileName, "UTF-8");
					rtn = rtn.replace("+", "%20");    //IE下载文件名空格变+号问�?
				}
				// Safari浏览�?,火狐浏览器，只能采用ISO编码的中文输�?
				else if (userAgent.indexOf("safari") != -1 || userAgent.indexOf("mozilla") != -1) {
					rtn = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
				}
//				// Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输�?
//				else if (userAgent.indexOf("applewebkit") != -1) {
//					new_filename = MimeUtility.encodeText(fileName, "UTF8", "B");
//					rtn = "filename=\"" + new_filename + "\"";
//				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rtn;
}
}
