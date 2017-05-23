package com.fda.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fda.constants.RescodeConstants;
import com.fda.controller.res.ListResult;
import com.fda.model.StudentBean;
import com.fda.model.StudentHomeBean;
import com.fda.persist.dao.StudentDao;
import com.fda.service.StudentService;
import com.fda.service.exception.ServiceException;
import com.fda.util.AppTextUtil;
import com.fda.util.StringUtil;


@Service
public class StudentServiceImpl  implements StudentService {

	@Autowired
	StudentDao studentImpl;
	
	@Override
	public ListResult<StudentBean>  getStudents(int start, int pageSize,String homeId) {
		ListResult<StudentBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", pageSize);
		if(!StringUtil.checkEmpty(homeId)){
			params.put("homeId", homeId);
		}
		int totalSize = studentImpl.selectTotal(params);
		List<StudentBean> beans = studentImpl.selectStudentsInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public StudentBean getStudentById(String id) {
		return studentImpl.selectStudentById(id);
	}

	@Override
	public boolean saveStudent(StudentBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getSid());
		if (isNew) {
			bean.setSid(AppTextUtil.getPrimaryKey());
			flag = studentImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = studentImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteStudentById(String id) throws ServiceException {
		boolean flag = false;
		flag = studentImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		flag = studentImpl.deleteStudentHome(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean saveHomeId(String[] homeIds, String studentId) throws ServiceException {
		boolean flag = true;
		StudentBean student = studentImpl.selectStudentById(studentId);
		if (student == null) {
			throw new ServiceException(RescodeConstants.getInstance().get("object_is_not_exist"), "学生");
		}
		if(homeIds == null || homeIds.length == 0) {
			throw new ServiceException(RescodeConstants.getInstance().get("object_is_not_exist"), "选择页面");
		}
		int count = studentImpl.selectHomeCount(studentId);
		if(count > 0) {
			flag = studentImpl.deleteStudentHome(studentId) > 0;
			if(!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_del_fail"));
			}
		}
		List<StudentHomeBean> data = new ArrayList<>();
		for(String hid : homeIds) {
			StudentHomeBean s = new StudentHomeBean();
			s.setAid(AppTextUtil.getPrimaryKey());
			s.setStudentId(studentId);
			s.setHomeId(hid);
			data.add(s);
		}
		flag = studentImpl.insertStudentHome(data) > 0;
		return flag;
	}

	@Override
	public List<StudentHomeBean> selectHomesByStudentId(String studentId) {
		return studentImpl.selectStudentHome(studentId);
	}

}
