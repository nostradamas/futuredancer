package com.fdm.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fdm.model.file.UploadFileInfo;
import com.fdm.service.exception.ServiceException;

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

