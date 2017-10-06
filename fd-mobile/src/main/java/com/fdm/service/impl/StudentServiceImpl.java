package com.fdm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.controller.res.ListResult;
import com.fdm.controller.resmodel.ResStudentBean;
import com.fdm.model.QuestionBean;
import com.fdm.model.StudentBean;
import com.fdm.persist.dao.StudentDao;
import com.fdm.service.StudentService;
import com.fdm.util.AppTextUtil;


@Service
public class StudentServiceImpl  implements StudentService {

	@Autowired
	StudentDao studentImpl;
	
	@Override
	public ListResult<ResStudentBean>  getStudents(int start, int pageSize) {
		ListResult<ResStudentBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", pageSize);
		int totalSize = studentImpl.selectTotal(params);
		List<StudentBean> beans = studentImpl.selectStudentsInPage(params);
		List<ResStudentBean> resData = new ArrayList<>();
		
		if(totalSize > 0 && beans != null){
			for(StudentBean s : beans){
				ResStudentBean res = new ResStudentBean();
				res.setSid(s.getSid());
				res.setBrief(s.getBrief());
				res.setImg(s.getImg());
				res.setName(s.getName());
				resData.add(res);
			}
		}
		
		result.setData(resData);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public StudentBean getStudentById(String id) {
		return studentImpl.selectStudentById(id);
	}

	@Override
	public boolean saveQuestion(QuestionBean bean) {
		bean.setQid(AppTextUtil.getPrimaryKey());
		return studentImpl.insertQuestion(bean) > 0;
	}

}
