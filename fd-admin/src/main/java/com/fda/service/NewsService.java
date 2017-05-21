package com.fda.service;

import java.util.List;

import com.fda.controller.res.ListResult;
import com.fda.model.NewsBean;
import com.fda.model.NewsCategoryBean;


/**
 * 新闻service层
 * 
 * @author nostr
 *
 */
public interface NewsService {


	ListResult<NewsBean> getNewsList(int start, int pageSize, String cid, String sch_name);

	List<NewsCategoryBean> getNewsCategory(String sch_name);

	NewsBean getNewsById(String nid);

	boolean save(NewsBean bean);

	boolean deleteById(String id);

	NewsCategoryBean getNewsCategoryById(String id);

	boolean saveCategory(NewsCategoryBean bean);

	boolean deleteCategoryById(String id);

}
