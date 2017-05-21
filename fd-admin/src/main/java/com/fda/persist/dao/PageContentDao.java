package com.fda.persist.dao;

import java.util.List;
import java.util.Map;

import com.fda.model.PageContentBean;



/**
 * 项目内容页数据层
 * @author nostr
 *
 */
public interface PageContentDao {

	int selectTotal(Map<String, Object> params);

	List<PageContentBean> selectPageContentInPage(Map<String, Object> params);

	PageContentBean selectPageContentById(String id);

	int insert(PageContentBean bean);

	int update(PageContentBean bean);

	int deleteById(String id);
	
}
