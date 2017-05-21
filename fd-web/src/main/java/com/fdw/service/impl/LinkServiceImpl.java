package com.fdw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.controller.res.ListResult;
import com.fdw.model.LinkBean;
import com.fdw.persist.dao.LinkDao;
import com.fdw.service.LinkService;


@Service
public class LinkServiceImpl  implements LinkService {

	@Autowired
	LinkDao linkImpl;

	@Override
	public ListResult<LinkBean> getLinkLists() {
		ListResult<LinkBean> result = new ListResult<>();
		int totalSize = linkImpl.selectTotal();
		List<LinkBean> beans = linkImpl.selectLinks();
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}
	


}
