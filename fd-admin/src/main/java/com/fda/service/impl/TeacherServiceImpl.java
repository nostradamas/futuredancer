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
import com.fda.model.TeacherBean;
import com.fda.model.TeacherHomeBean;
import com.fda.persist.dao.TeacherDao;
import com.fda.service.TeacherService;
import com.fda.service.exception.ServiceException;
import com.fda.util.AppTextUtil;
import com.fda.util.StringUtil;


@Service
public class TeacherServiceImpl  implements TeacherService {

	@Autowired
	TeacherDao teacherImpl;

	@Override
	public ListResult<TeacherBean> getTeacherLists(Integer start, Integer length, String homeId, int type) {
		ListResult<TeacherBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", length);
		params.put("type", type);
		if(!StringUtil.checkEmpty(homeId)){
			params.put("homeId", homeId);
		}
		int totalSize = teacherImpl.selectTotal(params);
		List<TeacherBean> beans = teacherImpl.selectTeachersInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public TeacherBean getTeacherById(String id) {
		return teacherImpl.selectTeacherById(id);
	}

	@Override
	public boolean saveTeacher(TeacherBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getTid());
		if (isNew) {
			bean.setTid(AppTextUtil.getPrimaryKey());
			flag = teacherImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = teacherImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteTeacherById(String id) throws ServiceException {
		boolean flag = false;
		flag = teacherImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean saveHomeId(String[] homeIds, String teacherId) throws ServiceException {
		boolean flag = true;
		TeacherBean teacher = teacherImpl.selectTeacherById(teacherId);
		if (teacher == null) {
			throw new ServiceException(RescodeConstants.getInstance().get("object_is_not_exist"), "学生");
		}
		if(homeIds == null || homeIds.length == 0) {
			throw new ServiceException(RescodeConstants.getInstance().get("object_is_not_exist"), "选择页面");
		}
		int count = teacherImpl.selectHomeCount(teacherId);
		if(count > 0) {
			flag = teacherImpl.deleteTeacherHome(teacherId) > 0;
			if(!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_del_fail"));
			}
		}
		List<TeacherHomeBean> data = new ArrayList<>();
		for(String hid : homeIds) {
			TeacherHomeBean t = new TeacherHomeBean();
			t.setAid(AppTextUtil.getPrimaryKey());
			t.setTeacherId(teacherId);
			t.setHomeId(hid);
			data.add(t);
		}
		flag = teacherImpl.insertTeacherHome(data) > 0;
		return flag;
	}

	@Override
	public List<TeacherHomeBean> selectHomesByTeacherId(String teacherId) {
		return teacherImpl.selectTeacherHome(teacherId);
	}

}
