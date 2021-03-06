package com.fdm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.constants.RescodeConstants;
import com.fdm.controller.res.ListResult;
import com.fdm.model.ClassIntroduceBean;
import com.fdm.persist.dao.ClassIntroduceDao;
import com.fdm.service.ClassIntroduceService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.AppTextUtil;
import com.fdm.util.StringUtil;


@Service
public class ClassIntroduceServiceImpl  implements ClassIntroduceService {

	@Autowired
	ClassIntroduceDao classIntroduceImpl;
	
	@Override
	public ListResult<ClassIntroduceBean> getClassIntroduceLists(Integer start, Integer length) {
		ListResult<ClassIntroduceBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", length);
		int totalSize = classIntroduceImpl.selectTotal(params);
		List<ClassIntroduceBean> beans = classIntroduceImpl.selectClassIntroducesInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public ClassIntroduceBean getClassIntroduceById(String id) {
		return classIntroduceImpl.selectClassIntroduceById(id);
	}

	@Override
	public boolean saveClassIntroduce(ClassIntroduceBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getCid());
		if (isNew) {
			bean.setCid(AppTextUtil.getPrimaryKey());
			flag = classIntroduceImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = classIntroduceImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteClassIntroduceById(String id) {
		boolean flag = false;
		flag = classIntroduceImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}



}
