package com.fdm.service;

import java.util.List;

import com.fdm.controller.res.ListResult;
import com.fdm.model.StudentBean;
import com.fdm.model.StudentHomeBean;
import com.fdm.service.exception.ServiceException;

/**
 * 学生service层
 * 
 * @author nostr
 *
 */
public interface StudentService {


	ListResult<StudentBean> getStudents(int page, int pageSize, String homeId);

	StudentBean getStudentById(String id);

	boolean deleteStudentById(String id) throws ServiceException;

	boolean saveStudent(StudentBean bean);

	boolean saveHomeId(String[] homeIds, String studentId) throws ServiceException;

	List<StudentHomeBean> selectHomesByStudentId(String studentId);

}
