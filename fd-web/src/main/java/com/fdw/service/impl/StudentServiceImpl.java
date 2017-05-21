package com.fdw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.controller.res.ListResult;
import com.fdw.model.StudentBean;
import com.fdw.persist.dao.StudentDao;
import com.fdw.service.StudentService;
import com.fdw.util.StringUtil;

@Service
public class StudentServiceImpl  implements StudentService {

	@Autowired
	StudentDao studentImpl;
	
	@Override
	public ListResult<StudentBean>  getStudents(int page, int pageSize,String homeId, int atHome) {
		ListResult<StudentBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		int start = (page - 1) * pageSize;
		params.put("start", start);
		params.put("pageSize", pageSize);
		params.put("atHome", atHome);
		if(!StringUtil.checkEmpty(homeId)){
			params.put("homeId", homeId);
		}
		int totalSize = studentImpl.selectTotal(params);
		List<StudentBean> beans = studentImpl.selectStudentsInPage(params);
		result.setPage(page);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

}
