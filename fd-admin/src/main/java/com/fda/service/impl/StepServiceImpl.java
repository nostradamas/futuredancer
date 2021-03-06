package com.fda.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fda.constants.RescodeConstants;
import com.fda.controller.res.ListResult;
import com.fda.model.StepBean;
import com.fda.persist.dao.StepDao;
import com.fda.service.StepService;
import com.fda.service.exception.ServiceException;
import com.fda.util.AppTextUtil;
import com.fda.util.StringUtil;


@Service
public class StepServiceImpl implements StepService {

	@Autowired
	StepDao stepImpl;
	
	@Override
	public ListResult<StepBean> getStepLists(Integer start, Integer length, String homeId) {
		ListResult<StepBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", length);
		if(!StringUtil.checkEmpty(homeId)){
			params.put("hid", homeId);
		}
		int totalSize = stepImpl.selectTotal(params);
		List<StepBean> beans = stepImpl.selectStepsInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public StepBean getStepById(String id) {
		return stepImpl.selectStepById(id);
	}

	@Override
	public boolean saveStep(StepBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getSid());
		if (isNew) {
			bean.setSid(AppTextUtil.getPrimaryKey());
			flag = stepImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = stepImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteStepById(String id) {
		boolean flag = false;
		flag = stepImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}


}
