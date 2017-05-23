package com.fdw.service;

import com.fdw.controller.res.ListResult;
import com.fdw.model.StudentBean;

/**
 * 学生service层
 * 
 * @author nostr
 *
 */
public interface StudentService {


	ListResult<StudentBean> getStudents(int page, int pageSize, String homeId);

}
