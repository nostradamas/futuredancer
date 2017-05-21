package com.fda.service;

import com.fda.controller.res.ListResult;
import com.fda.model.PageContentBean;

/**
 * 页面内容 业务层
 * @author nostr
 *
 */
public interface PageContentService {

	ListResult<PageContentBean> getLists(Integer start, Integer length, String homeId);

	PageContentBean getContentById(String id);

	boolean savePageContent(PageContentBean bean);

	boolean deletePageContentById(String id);
	
}
