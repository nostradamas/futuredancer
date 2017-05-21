package com.fdw.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdw.model.NewsBean;
import com.fdw.model.NewsCategoryBean;

/**
 * 新闻数据层
 * @author nostr
 *
 */
public interface NewsDao {


	List<NewsBean> selectNewsInPage(Map<String, Object> params);

	int selectTotal(Map<String, Object> params);
	

	List<NewsCategoryBean> selectNewsCategory();

	NewsBean selectNewsById(String nid);

	NewsBean selectNewsByCode(String newscode);

}
