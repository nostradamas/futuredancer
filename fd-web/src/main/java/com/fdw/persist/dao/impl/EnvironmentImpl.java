package com.fdw.persist.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdw.model.EnvironmentBean;
import com.fdw.persist.dao.EnvironmentDao;

@Repository
public class EnvironmentImpl extends BaseImpl implements EnvironmentDao {

	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".EnvironmentMapper";

	@Override
	public List<EnvironmentBean> selectEnvironments(int type) {
		Map<String, Object> params = new HashMap<>();
		params.put("type", type);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectEnvironments",params);
	}

}
