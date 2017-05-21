package com.fda.service;

import com.fda.controller.res.ListResult;
import com.fda.model.ClassBean;

/**
 * 课程service层
 * 
 * @author nostr
 *
 */
public interface ClassService {


	ListResult<ClassBean> getClasses(int page, int pageSize);

	ClassBean getClassById(String cid);

	boolean saveClass(ClassBean bean);

	boolean deleteClassById(String id);

}
