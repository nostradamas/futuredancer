package com.fda.service;

import com.fda.controller.res.ListResult;
import com.fda.model.TeacherBean;

/**
 * 授课教师service层
 * 
 * @author nostr
 *
 */
public interface TeacherService {

	ListResult<TeacherBean> getTeacherLists(Integer start, Integer length,String homeId , int type);

	TeacherBean getTeacherById(String id);

	boolean saveTeacher(TeacherBean bean);

	boolean deleteTeacherById(String id);

}
