package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.NewsBean;
import com.fdm.model.NewsCategoryBean;



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
	
	int selectTotalInType(Map<String, Object> params);

	List<NewsBean> selectNewsInPageInType(Map<String, Object> params);

	
	///==========新闻分类==========////
	
	List<NewsCategoryBean> selectNewsCategory(String schcontent);

	int insertCategory(NewsCategoryBean bean);

	int updateCategory(NewsCategoryBean bean);

	int deleteCategoryById(String id);

	NewsCategoryBean selectNewsCategoryById(String id);


}
