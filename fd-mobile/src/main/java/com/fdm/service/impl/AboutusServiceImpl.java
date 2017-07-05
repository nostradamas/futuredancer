package com.fdm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.constants.RescodeConstants;
import com.fdm.controller.res.ListResult;
import com.fdm.model.AboutusBean;
import com.fdm.model.EnvironmentBean;
import com.fdm.persist.dao.AboutusDao;
import com.fdm.persist.dao.EnvironmentDao;
import com.fdm.persist.dao.PageContentDao;
import com.fdm.service.AboutusService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.AppTextUtil;
import com.fdm.util.StringUtil;


@Service
public class AboutusServiceImpl  implements AboutusService {
	
	@Autowired
	PageContentDao pageContentImpl;
	
	@Autowired
	AboutusDao aboutusImpl;

	@Autowired
	EnvironmentDao environmentImpl;

	@Override
	public AboutusBean getAboutus() {
		return aboutusImpl.selectAboutus();
	}

	@Override
	public boolean saveAboutus(AboutusBean bean) {
		return aboutusImpl.update(bean) > 0;
	}

	//=======================证书、 环境===============================

	@Override
	public ListResult<EnvironmentBean> getEnvironmentLists(Integer start, Integer length, int type) {
		ListResult<EnvironmentBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", length);
		if(type != 0) {
			params.put("type", type);
		}
		int totalSize = environmentImpl.selectTotal(params);
		List<EnvironmentBean> beans = environmentImpl.selectEnvironmentsInPage(params);

		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public EnvironmentBean getEnvironmentById(String id) {
		return environmentImpl.selectEnvironmentById(id);
	}

	@Override
	public boolean saveEnvironment(EnvironmentBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getEid());
		if (isNew) {
			bean.setEid(AppTextUtil.getPrimaryKey());
			flag = environmentImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = environmentImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteEnvironmentById(String id) throws ServiceException {
		boolean flag = false;
		flag = environmentImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}


}
