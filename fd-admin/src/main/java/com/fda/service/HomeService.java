package com.fda.service;

import com.fda.controller.res.ListResult;
import com.fda.model.HomeBean;
import com.fda.model.IndexContentBean;


/**
 * 主页面service层
 * 
 * @author nostr
 *
 */
public interface HomeService {

	ListResult<HomeBean> getHomeLists(Integer start, Integer length);

	HomeBean getHomeById(String id);

	boolean saveHome(HomeBean bean);

	boolean deleteHomeById(String id);

	//====================首页内容========================
	ListResult<IndexContentBean> getContentLists(Integer start, Integer length, String homeId);

	IndexContentBean getContentById(String id);

	boolean saveContent(IndexContentBean bean);

	boolean deleteContentById(String id);

}
