package com.fdm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.controller.res.ListResult;
import com.fdm.controller.resmodel.ResTeacherBean;
import com.fdm.model.TeacherBean;
import com.fdm.persist.dao.TeacherDao;
import com.fdm.service.TeacherService;


@Service
public class TeacherServiceImpl  implements TeacherService {

	@Autowired
	TeacherDao teacherImpl;

	@Override
	public ListResult<ResTeacherBean> getTeacherLists(Integer start, Integer pageSize, int level, int targetId, int type) {
		ListResult<ResTeacherBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", pageSize);
		params.put("targetId", targetId);
		params.put("level", level);
		params.put("direction", type);
		int totalSize = teacherImpl.selectTotal(params);
		List<TeacherBean> beans = teacherImpl.selectTeachersInPage(params);
		List<ResTeacherBean> resData = new ArrayList<>();
		
		if(totalSize > 0 && beans != null){
			for(TeacherBean t : beans){
				ResTeacherBean res = new ResTeacherBean();
				res.setBrief(t.getBrief());
				res.setDetail(t.getDetail());
				res.setImg(t.getImg());
				res.setName(t.getName());
				res.setTid(t.getTid());
				res.setLevel(t.getLevel());
				res.setDirection(t.getDirection());
				res.setTargetId(t.getTargetId());
				res.setTag(t.getDirection());
				resData.add(res);
			}
		}
		
		result.setData(resData);
		result.setTotalSize(totalSize);
		return result;
	}

}
