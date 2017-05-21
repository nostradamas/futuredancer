package com.fdw.service;

import com.fdw.controller.res.ListResult;
import com.fdw.model.TeacherBean;

/**
 * 授课教师service层
 * 
 * @author nostr
 *
 */
public interface TeacherService {


	ListResult<TeacherBean> getTeachers(int page, int pageSize,String homeId,int typed, int atHome);


}
