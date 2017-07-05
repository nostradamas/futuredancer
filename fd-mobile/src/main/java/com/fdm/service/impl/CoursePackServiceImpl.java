package com.fdm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.constants.RescodeConstants;
import com.fdm.controller.res.ListResult;
import com.fdm.model.CoursePackBean;
import com.fdm.persist.dao.CoursePackDao;
import com.fdm.service.CoursePackService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.AppTextUtil;
import com.fdm.util.StringUtil;


@Service
public class CoursePackServiceImpl  implements CoursePackService {

	@Autowired
	CoursePackDao coursePackImpl;
	
	@Override
	public ListResult<CoursePackBean> getCoursePackLists(Integer start, Integer length, String homeId) {
		ListResult<CoursePackBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", length);
		if(!StringUtil.checkEmpty(homeId)){
			params.put("homeId", homeId);
		}
		int totalSize = coursePackImpl.selectTotal(params);
		List<CoursePackBean> beans = coursePackImpl.selectCoursePacksInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public CoursePackBean getCoursePackById(String id) {
		return coursePackImpl.selectCoursePackById(id);
	}

	@Override
	public boolean saveCoursePack(CoursePackBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getCid());
		if (isNew) {
			bean.setCid(AppTextUtil.getPrimaryKey());
			flag = coursePackImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = coursePackImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteCoursePackById(String id) {
		boolean flag = false;
		flag = coursePackImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}


}
