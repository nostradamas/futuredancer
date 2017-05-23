package com.fdw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.controller.res.ListResult;
import com.fdw.model.TeacherBean;
import com.fdw.persist.dao.ClassIntroduceDao;
import com.fdw.persist.dao.TeacherDao;
import com.fdw.service.TeacherService;

@Service
public class TeacherServiceImpl  implements TeacherService {

	@Autowired
	TeacherDao teacherImpl;

	@Autowired
	ClassIntroduceDao classIntroduceImpl;
	
	@Override
	public ListResult<TeacherBean>  getTeachers(int page, int pageSize,String homeId, int type) {
		ListResult<TeacherBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("type", type);
		params.put("homeId", homeId);
		int totalSize = teacherImpl.selectTotal(params);
		pageSize = pageSize > totalSize ? totalSize : pageSize;
		int start = (page - 1) * pageSize;
		params.put("start", start);
		params.put("pageSize", pageSize);
		List<TeacherBean> beans = teacherImpl.selectTeachersInPage(params);
		result.setPage(page);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

}
