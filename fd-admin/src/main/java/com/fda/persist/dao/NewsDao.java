package com.fda.persist.dao;

import java.util.List;
import java.util.Map;

import com.fda.model.NewsBean;
import com.fda.model.NewsCategoryBean;



/**
 * 新闻数据层
 * @author nostr
 *
 */
public interface NewsDao {


	List<NewsBean> selectNewsInPage(Map<String, Object> params);

	int selectTotal(Map<String, Object> params);
	
	NewsBean selectNewsById(String nid);

	int insert(NewsBean bean);

	int update(NewsBean bean);

	int deleteById(String id);

	
	///==========新闻分类==========////
	
	List<NewsCategoryBean> selectNewsCategory(String schcontent);

	int insertCategory(NewsCategoryBean bean);

	int updateCategory(NewsCategoryBean bean);

	int deleteCategoryById(String id);

	NewsCategoryBean selectNewsCategoryById(String id);

}
