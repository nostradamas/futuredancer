package com.fda.service;

import java.util.List;

import com.fda.controller.res.ListResult;
import com.fda.model.TeacherBean;
import com.fda.model.TeacherHomeBean;
import com.fda.service.exception.ServiceException;

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
