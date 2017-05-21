package com.fdw.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdw.model.NewsBean;
import com.fdw.model.NewsCategoryBean;
import com.fdw.persist.dao.NewsDao;

@Repository
public class NewsImpl extends BaseImpl  implements NewsDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".NewsMapper";

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public List<NewsBean> selectNewsInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectNewsInPage",params);
	}

	@Override
	public List<NewsCategoryBean> selectNewsCategory() {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectNewsCategory");
	}

	@Override
	public NewsBean selectNewsById(String nid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectNewsById", nid);
	}

	@Override
	public NewsBean selectNewsByCode(String newscode) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectNewsByCode", newscode);
	}
	
}
