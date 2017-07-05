package com.fdm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.constants.RescodeConstants;
import com.fdm.controller.res.ListResult;
import com.fdm.model.ClassBean;
import com.fdm.persist.dao.ClassDao;
import com.fdm.service.ClassService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.AppTextUtil;
import com.fdm.util.StringUtil;


@Service
public class ClassServiceImpl  implements ClassService {

	@Autowired
	ClassDao classImpl;
	
	@Override
	public ListResult<ClassBean>  getClasses(int start, int pageSize) {
		ListResult<ClassBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", pageSize);
		int totalSize = classImpl.selectTotal(params);
		List<ClassBean> beans = classImpl.selectClassesInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public ClassBean getClassById(String cid) {
		return classImpl.selectClassById(cid);
	}

	@Override
	public boolean saveClass(ClassBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getCid());
		if (isNew) {
			bean.setCid(AppTextUtil.getPrimaryKey());
			flag = classImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = classImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteClassById(String id) throws ServiceException {
		boolean flag = false;
		flag = classImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}
}
