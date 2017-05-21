package com.fdw.service;

import java.util.List;

import com.fdw.controller.res.ListResult;
import com.fdw.controller.res.ResNewsList;
import com.fdw.model.NewsBean;
import com.fdw.model.NewsCategoryBean;

/**
 * 新闻service层
 * 
 * @author nostr
 *
 */
public interface NewsService {


	ListResult<ResNewsList> getNewsList(int page, int pageSize, String cid);

	List<NewsCategoryBean> getNewsCategory();

	NewsBean getNewsById(String nid);

	NewsBean getNewsByCode(String newscode);

}
