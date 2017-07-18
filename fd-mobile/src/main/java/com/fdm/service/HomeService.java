package com.fdm.service;

import com.fdm.controller.res.ListResult;
import com.fdm.model.HomeBean;


/**
 * 主页面service层
 * 
 * @author nostr
 *
 */
public interface HomeService {

	HomeBean getHomeById(String id);

	ListResult<HomeBean> getHomeLists(int page, int pageSize);

}
