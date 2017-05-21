package com.fda.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fda.constants.RescodeConstants;
import com.fda.controller.res.ListResult;
import com.fda.model.HomeBean;
import com.fda.model.IndexContentBean;
import com.fda.persist.dao.HomeDao;
import com.fda.persist.dao.IndexContentDao;
import com.fda.service.HomeService;
import com.fda.service.exception.ServiceException;
import com.fda.util.AppTextUtil;
import com.fda.util.StringUtil;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	HomeDao homeImpl;
	

	@Autowired
	IndexContentDao indexContentImpl;
	
	@Override
	public ListResult<HomeBean> getHomeLists(Integer start, Integer length) {
		ListResult<HomeBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", length);
		int totalSize = homeImpl.selectTotal(params);
		List<HomeBean> beans = homeImpl.selectHomeInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public HomeBean getHomeById(String id) {
		return homeImpl.selectHomeById(id);
	}

	@Override
	public boolean saveHome(HomeBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getHid());
		if (isNew) {
			bean.setHid(AppTextUtil.getPrimaryKey());
			flag = homeImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = homeImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteHomeById(String id) throws ServiceException {
		boolean flag = false;
		flag = homeImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}

	@Override
	public ListResult<IndexContentBean> getContentLists(Integer start, Integer length, String homeId) {
		ListResult<IndexContentBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", length);
		params.put("homeId", homeId);
		int totalSize = indexContentImpl.selectContentTotal(params);
		List<IndexContentBean> beans = indexContentImpl.selectContentInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public IndexContentBean getContentById(String id) {
		return indexContentImpl.selectContentById(id);
	}

	@Override
	public boolean saveContent(IndexContentBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getMid());
		if (isNew) {
			bean.setMid(AppTextUtil.getPrimaryKey());
			flag = indexContentImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = indexContentImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteContentById(String id) throws ServiceException {
		boolean flag = false;
		flag = indexContentImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}

}
