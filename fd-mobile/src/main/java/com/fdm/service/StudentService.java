package com.fdm.service;

import com.fdm.controller.res.ListResult;
import com.fdm.controller.resmodel.ResStudentBean;
import com.fdm.model.QuestionBean;
import com.fdm.model.StudentBean;

/**
 * 学生service层
 * 
 * @author nostr
 *
 */
public interface StudentService {

	ListResult<ResStudentBean> getStudents(int page, int pageSize);

	StudentBean getStudentById(String id);

	boolean saveQuestion(QuestionBean bean);

}
