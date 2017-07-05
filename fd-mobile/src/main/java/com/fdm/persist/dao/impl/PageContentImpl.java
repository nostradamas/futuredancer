package com.fdm.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdm.model.PageContentBean;
import com.fdm.persist.dao.PageContentDao;


@Repository
public class PageContentImpl extends BaseImpl implements PageContentDao {

	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".PageContentMapper";

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public List<PageContentBean> selectPageContentInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectPageContentInPage", params);

	}

	@Override
	public PageContentBean selectPageContentById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectPageContentById", id);
	}

	@Override
	public int insert(PageContentBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(PageContentBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}


}
