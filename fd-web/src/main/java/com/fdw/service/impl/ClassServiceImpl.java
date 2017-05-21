package com.fdw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.controller.res.ListResult;
import com.fdw.model.ClassBean;
import com.fdw.model.ClassIntroduceBean;
import com.fdw.persist.dao.ClassDao;
import com.fdw.service.ClassService;

@Service
public class ClassServiceImpl  implements ClassService {

	@Autowired
	ClassDao classImpl;
	
	@Override
	public ListResult<ClassBean>  getClasses(int page, int pageSize,String homeId) {
		ListResult<ClassBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		int start = (page - 1) * pageSize;
		params.put("start", start);
		params.put("pageSize", pageSize);
		params.put("homeId", homeId);
		int totalSize = classImpl.selectTotal(params);
		List<ClassBean> beans = classImpl.selectClassesInPage(params);
		result.setPage(page);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public ClassBean getClassById(String cid) {
		return classImpl.selectClassById(cid);
	}

	@Override
	public List<ClassIntroduceBean> getClassMenus(String tabId) {
		return classImpl.selectClassMenus(tabId);
	}

}
