package com.fdm.service;

import java.util.List;

import com.fdm.controller.res.ListResult;
import com.fdm.controller.resmodel.ResNewsListBean;
import com.fdm.model.NewsBean;
import com.fdm.model.NewsCategoryBean;


/**
 * 新闻service层
 * 
 * @author nostr
 *
 */
public interface NewsService {


	ListResult<ResNewsListBean> getNewsList(int start, int pageSize, String cid, String sch_name);
	
	NewsBean getNewsById(String nid);
	
	List<NewsCategoryBean> getNewsCategory(String sch_name);
	
}
