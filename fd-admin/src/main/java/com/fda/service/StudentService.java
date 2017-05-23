package com.fda.service;

import java.util.List;

import com.fda.controller.res.ListResult;
import com.fda.model.StudentBean;
import com.fda.model.StudentHomeBean;
import com.fda.service.exception.ServiceException;

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
