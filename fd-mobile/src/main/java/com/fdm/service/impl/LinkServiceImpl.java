package com.fdm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.constants.RescodeConstants;
import com.fdm.controller.res.ListResult;
import com.fdm.model.LinkBean;
import com.fdm.persist.dao.LinkDao;
import com.fdm.service.LinkService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.AppTextUtil;
import com.fdm.util.StringUtil;


@Service
public class LinkServiceImpl  implements LinkService {

	@Autowired
	LinkDao linkImpl;
	
	@Override
	public ListResult<LinkBean> getLinkLists(Integer start, Integer length) {
		ListResult<LinkBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", length);
		int totalSize = linkImpl.selectTotal(params);
		List<LinkBean> beans = linkImpl.selectLinksInPage(params);
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public LinkBean getLinkById(String id) {
		return linkImpl.selectLinkById(id);
	}

	@Override
	public boolean saveLink(LinkBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getLid());
		if (isNew) {
			bean.setLid(AppTextUtil.getPrimaryKey());
			flag = linkImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = linkImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteLinkById(String id) {
		boolean flag = false;
		flag = linkImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}


}
