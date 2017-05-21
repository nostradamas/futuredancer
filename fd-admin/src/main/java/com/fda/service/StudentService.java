package com.fda.service;

import com.fda.controller.res.ListResult;
import com.fda.model.StudentBean;

/**
 * 学生service层
 * 
 * @author nostr
 *
 */
public interface StudentService {


	ListResult<StudentBean> getStudents(int page, int pageSize, String homeId);

	StudentBean getStudentById(String id);

	boolean deleteStudentById(String id);

	boolean saveStudent(StudentBean bean);

}
