package com.fda.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fda.constants.RescodeConstants;
import com.fda.controller.res.ListResult;
import com.fda.model.PageContentBean;
import com.fda.persist.dao.PageContentDao;
import com.fda.service.PageContentService;
import com.fda.service.exception.ServiceException;
import com.fda.util.AppTextUtil;
import com.fda.util.StringUtil;


@Service
public class PageContentServiceImpl  implements PageContentService {
	
	@Autowired
	PageContentDao pageContentImpl;

	@Override
	public ListResult<PageContentBean> getLists(Integer start, Integer length, String homeId) {
		ListResult<PageContentBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", length);
		if(!StringUtil.checkEmpty(homeId)){
			params.put("targetId", homeId);
		}
		int totalSize = pageContentImpl.selectTotal(params);
		List<PageContentBean> beans = pageContentImpl.selectPageContentInPage(params);

		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public PageContentBean getContentById(String id) {
		return pageContentImpl.selectPageContentById(id);
	}

	@Override
	public boolean savePageContent(PageContentBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getPid());
		if (isNew) {
			bean.setPid(AppTextUtil.getPrimaryKey());
			flag = pageContentImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = pageContentImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deletePageContentById(String id) throws ServiceException {
		boolean flag = false;
		flag = pageContentImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}

	

}
