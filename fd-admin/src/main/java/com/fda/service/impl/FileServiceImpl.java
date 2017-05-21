package com.fda.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fda.constants.RescodeConstants;
import com.fda.model.file.UploadFileInfo;
import com.fda.service.FileService;
import com.fda.service.exception.ServiceException;
import com.fda.util.QiniuUtil;
import com.fda.util.RandomUtil;
import com.fda.util.StringUtil;

/**
 * 上传文件处理业务层
 */
@Service("fileServiceImpl")
public class FileServiceImpl implements FileService {


    @Override
    public List<UploadFileInfo> uploadUEImg(HttpServletRequest request, String imgPrefix, String[] fileTypes) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (!multipartResolver.isMultipart(request)) {
            throw new ServiceException(RescodeConstants.getInstance().get("object_is_not_exist").getCode(),
                    RescodeConstants.getInstance().get("object_is_not_exist").getMsg("文件"));
        }

        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        //获取文件
        Iterator<String> iterator = mRequest.getFileNames();
        List<UploadFileInfo> res = new ArrayList<>();
        while (iterator.hasNext()) {
            UploadFileInfo info = new UploadFileInfo();
            String key = iterator.next();
            MultipartFile file = mRequest.getFile(key);
            String originalFileName = file.getOriginalFilename();
            if (originalFileName == null || originalFileName.length() < 1) {
                break;
            }

            String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

            boolean flag = false;
            if (fileTypes != null && fileTypes.length > 0) {
                for (String t : fileTypes) {
                    if (suffix.equalsIgnoreCase(t)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                byte[] data = new byte[0];
                try {
                    data = file.getBytes();
                    String imgName = imgPrefix + System.currentTimeMillis() + RandomUtil.getRandomCharAndNum(6)+"."+suffix;
                    String qiniuReqKey = QiniuUtil.getInstance().upload(imgName, data);
                    if (!StringUtil.checkEmpty(qiniuReqKey)) {
                        info.setUpload(true);
                    }else{
                        info.setUpload(false);
                    }
                    info.setOriginalFilename(originalFileName);
                    info.setFileSize(file.getSize());
                    info.setFileName(imgName);
                    info.setFileType("."+suffix);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                info.setMsg("文件格式不正确！");
            }
            res.add(info);
        }
        return res;
    }

    @Override
    public String upload(String mediaId) {
        byte[] data = null;//MediaManager.getInstance().download(mediaId);

        String key = QiniuUtil.getInstance().upload(System.currentTimeMillis() + RandomUtil.getRandomCharAndNum(6),
                data);

        return key;
    }

    @Override
    public String upload(String mediaId, int x, int y, int w, int h) {
        byte[] data = null;//MediaManager.getInstance().download(mediaId);

        String key = QiniuUtil.getInstance().upload(System.currentTimeMillis() + RandomUtil.getRandomCharAndNum(6),
                data);

        return key;

    }

}
