package com.fdm.persist.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdm.model.NewsBean;
import com.fdm.model.NewsCategoryBean;
import com.fdm.persist.dao.NewsDao;


@Repository
public class NewsImpl extends BaseImpl  implements NewsDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".NewsMapper";

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public List<NewsBean> selectNewsInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectNewsInPage", params);
	}

	@Override
	public List<NewsCategoryBean> selectNewsCategory(String schcontent) {
		Map<String, Object> params = new HashMap<>();
		params.put("schcontent", schcontent);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectNewsCategory", params);
	}

	@Override
	public NewsBean selectNewsById(String nid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectNewsById", nid);
	}

	@Override
	public int insert(NewsBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertNews", bean);
	}

	@Override
	public int update(NewsBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".updateNews", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteNewsById", id);
	}

	@Override
	public int insertCategory(NewsCategoryBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertCategory", bean);
	}

	@Override
	public int updateCategory(NewsCategoryBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".updateCategory", bean);
	}

	@Override
	public int deleteCategoryById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteCategoryById", id);
	}

	@Override
	public NewsCategoryBean selectNewsCategoryById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectNewsCategoryById", id);
	}

	@Override
	public int selectTotalInType(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotalInType", params);
	}

	@Override
	public List<NewsBean> selectNewsInPageInType(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectNewsInPageInType", params);
	}
	

}
