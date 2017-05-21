package com.fdw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.controller.res.ListResult;
import com.fdw.model.CoursePackBean;
import com.fdw.persist.dao.CoursePackDao;
import com.fdw.service.CoursePackService;
import com.fdw.util.StringUtil;



@Service
public class CoursePackServiceImpl  implements CoursePackService {

	@Autowired
	CoursePackDao coursePackImpl;

	@Override
	public ListResult<CoursePackBean> getCoursePackLists(Integer page, Integer pageSize, String homeId) {
		ListResult<CoursePackBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		int start = (page - 1) * pageSize;
		params.put("start", start);
		params.put("pageSize", pageSize);
		if(!StringUtil.checkEmpty(homeId)){
			params.put("homeId", homeId);
		}
		int totalSize = coursePackImpl.selectTotal(params);
		List<CoursePackBean> beans = coursePackImpl.selectCoursePacksInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}


}
