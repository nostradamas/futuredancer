package com.fdw.persist.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdw.model.IndexContentBean;
import com.fdw.persist.dao.IndexContentDao;

@Repository
public class IndexContentImpl extends BaseImpl implements IndexContentDao {

	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".IndexContentMapper";

	@Override
	public List<IndexContentBean> selectIndexContents(String homeId, int type) {
		Map<String, Object> params = new HashMap<>();
		params.put("homeId", homeId);
		if(type != 0) {
			params.put("type", type);
		}
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectIndexContentByHid", params);

	}

}
