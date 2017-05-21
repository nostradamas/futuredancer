package com.fda.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fda.model.IndexContentBean;
import com.fda.persist.dao.IndexContentDao;

@Repository
public class IndexContentImpl extends BaseImpl implements IndexContentDao {

	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".IndexContentMapper";

	@Override
	public List<IndexContentBean> selectContentInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectContentInPage", params);
	}

	@Override
	public int selectContentTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public IndexContentBean selectContentById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectContentById", id);
	}

	@Override
	public int insert(IndexContentBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(IndexContentBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}
	

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}

}
