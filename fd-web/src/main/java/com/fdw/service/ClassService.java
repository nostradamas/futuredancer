package com.fdw.service;

import java.util.List;

import com.fdw.controller.res.ListResult;
import com.fdw.model.ClassBean;
import com.fdw.model.ClassIntroduceBean;

/**
 * 课程service层
 * 
 * @author nostr
 *
 */
public interface ClassService {


	ListResult<ClassBean> getClasses(int page, int pageSize,String homeId);

	ClassBean getClassById(String cid);
	
	/**
	 * 获取课程介绍内课程导航
	 * @param tabId
	 * @return
	 */
	List<ClassIntroduceBean> getClassMenus(String tabId);

}
