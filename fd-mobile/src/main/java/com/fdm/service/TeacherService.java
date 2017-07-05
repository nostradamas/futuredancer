package com.fdm.service;

import java.util.List;

import com.fdm.controller.res.ListResult;
import com.fdm.model.TeacherBean;
import com.fdm.model.TeacherHomeBean;
import com.fdm.service.exception.ServiceException;

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

	boolean deleteTeacherById(String id) throws ServiceException;

	boolean saveHomeId(String[] homeIds, String teacherId) throws ServiceException;

	List<TeacherHomeBean> selectHomesByTeacherId(String teacherId);

}
