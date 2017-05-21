package com.fdw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.controller.res.ListResult;
import com.fdw.model.ClassIntroduceBean;
import com.fdw.model.TeacherBean;
import com.fdw.persist.dao.ClassIntroduceDao;
import com.fdw.persist.dao.TeacherDao;
import com.fdw.service.TeacherService;
import com.fdw.util.StringUtil;

@Service
public class TeacherServiceImpl  implements TeacherService {

	@Autowired
	TeacherDao teacherImpl;

	@Autowired
	ClassIntroduceDao classIntroduceImpl;
	
	@Override
	public ListResult<TeacherBean>  getTeachers(int page, int pageSize,String homeId, int type, int atHome) {
		ListResult<TeacherBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		int start = (page - 1) * pageSize;
		params.put("start", start);
		params.put("pageSize", pageSize);
		params.put("type", type);
		if(!StringUtil.checkEmpty(homeId)){
			params.put("homeId", homeId);
			// 查询是否有子课程 儿童舞蹈课程包含子课程
			Map<String, Object> ps = new HashMap<>();
			ps.put("homeId", homeId);
			List<ClassIntroduceBean> intros = classIntroduceImpl.selectClassIntroducesByTabId(ps);
			if(intros != null && intros.size() > 0) {
				List<String> list = new ArrayList<String>();
				for(ClassIntroduceBean c : intros) {
					list.add(c.getCid());
				}
				params.put("tabs",list);
				atHome = 1;
			}
		}
		params.put("atHome", atHome);
		int totalSize = teacherImpl.selectTotal(params);
		List<TeacherBean> beans = teacherImpl.selectTeachersInPage(params);
		result.setPage(page);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

}
