package com.fdm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.controller.res.ListResult;
import com.fdm.model.HomeBean;
import com.fdm.persist.dao.HomeDao;
import com.fdm.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeDao homeImpl;

	@Override
	public HomeBean getHomeById(String id) {
		return homeImpl.selectHomeById(id);
	}

	@Override
	public ListResult<HomeBean> getHomeLists(int page, int pageSize) {
		ListResult<HomeBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", page);
		params.put("pageSize", pageSize);
		int totalSize = homeImpl.selectTotal(params);
		List<HomeBean> beans = homeImpl.selectHomeInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

}
