package com.fdm.service;

import com.fdm.controller.res.ListResult;
import com.fdm.model.ClassBean;

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
