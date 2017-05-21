package com.fda.service;


import javax.servlet.http.HttpServletRequest;

import com.fda.model.file.UploadFileInfo;
import com.fda.service.exception.ServiceException;

import java.util.List;

/**
 * @author 车库互联网+ 2016年10月25日
 */
public interface FileService {

    String upload(String mediaId);

    String upload(String mediaId, int x, int y, int w, int h);


    /**
     * 使用七牛云和百度富文本 图片上传
     * @param request
     * @param destName
     * @param fileTypes 文件类型
     * @throws ServiceException
     */
    List<UploadFileInfo> uploadUEImg(HttpServletRequest request, String destName, String[] fileTypes) throws ServiceException;
}

