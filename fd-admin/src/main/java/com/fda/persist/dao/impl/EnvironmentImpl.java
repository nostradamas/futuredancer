package com.fda.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fda.model.EnvironmentBean;
import com.fda.persist.dao.EnvironmentDao;


@Repository
public class EnvironmentImpl extends BaseImpl implements EnvironmentDao {

	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".EnvironmentMapper";

	@Override
	public List<EnvironmentBean> selectEnvironmentsInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectEnvironmentsInPage", params);
	}

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public EnvironmentBean selectEnvironmentById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectEnvironmentById", id);
	}

	@Override
	public int insert(EnvironmentBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(EnvironmentBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}

}
