package com.fdm.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.constants.AppConfig;
import com.fdm.controller.res.BaseResult;
import com.fdm.controller.res.ObjectResult;
import com.fdm.model.file.UploadFileInfo;
import com.fdm.service.FileService;
import com.fdm.util.FileUploadUtil;
import com.fdm.util.StringUtil;


/**
 * 文件相关接口
 **/
@Controller
@RequestMapping("file")
public class FileController {

	private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    FileService fileServiceImpl;
	/**
	 * 上传页面
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/toUpload")
	public ModelAndView toRole(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload");
		return mv;
	}

	/**
	 * 上传
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public ObjectResult<?> upload(HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<String> res = new ObjectResult<>();
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		try {
			if (multipartResolver.isMultipart(request)) {
				String fileUrl = FileUploadUtil.saveFile("expert_", request);
				res.setData(fileUrl);
				res.setRescode(fileUrl != null ? BaseResult.success.getCode() : BaseResult.fail.getCode());
				res.setMsg(fileUrl != null ? BaseResult.success.getMsg() : BaseResult.fail.getMsg());
			}
		} catch (IllegalStateException e) {
			res.setRescode(BaseResult.fail.getCode());
			res.setMsg(BaseResult.fail.getMsg());
		} catch (IOException e) {
			res.setRescode(BaseResult.fail.getCode());
			res.setMsg(BaseResult.fail.getMsg());
		}
		return res;
	}

	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request, HttpServletResponse response) {
		
		String fileName = StringUtil.toString(request.getParameter("fileName"), null);
		if (!StringUtil.checkEmpty(fileName)) {
			String savePath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");
			File downFiles = new File(savePath + File.separator + fileName);
			if (!downFiles.exists()) {
				return null;
			}
			try {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("application/octet-stream; charset=utf-8");
				String dfileName = FileUploadUtil.encodeFileName(request, fileName);
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.setContentDispositionFormData("attachment", dfileName);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(downFiles), headers, HttpStatus.OK);
			} catch (Exception e) {
				log.info("下载失败了......");
			}
		}
		return null;

	}
	
	 @RequestMapping("/uploadUEImg")
    @ResponseBody
    public Object uploadUEImg(HttpServletResponse response, HttpServletRequest request){
        Map<String,Object> result = new HashMap<String,Object>();
        String imgPerfix = request.getParameter("imgPerfix");
        List<UploadFileInfo> ds = fileServiceImpl.uploadUEImg(request,imgPerfix,new String[]{"jpeg","png","jpg"});
        if (ds!=null&&ds.size()>0){
            Iterator<UploadFileInfo> iterator = ds.iterator();
            while (iterator.hasNext()){
               UploadFileInfo uploadFileInfo =  iterator.next();
                result.put("state",uploadFileInfo.isUpload()==true?"SUCCESS":"FAIL");
                result.put("original",uploadFileInfo.getOriginalFilename());
                result.put("size",uploadFileInfo.getFileSize());
                result.put("title",uploadFileInfo.getFileName());
                result.put("type",uploadFileInfo.getFileType());
                String url = AppConfig.instance().getQINIU_IMGAGE_URL()+ uploadFileInfo.getFileName();
                result.put("url",url);
            }
        }
        return  result;
    }

}
