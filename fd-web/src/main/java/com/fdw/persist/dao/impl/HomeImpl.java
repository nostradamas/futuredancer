package com.fdw.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdw.model.HomeBean;
import com.fdw.model.PosterBean;
import com.fdw.persist.dao.HomeDao;

@Repository
public class HomeImpl extends BaseImpl  implements HomeDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".HomeMapper";
	
	@Override
	public HomeBean selectHomeBean(String hid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectHomeById", hid);
	}
	
	@Override
	public String selectHomeId() {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectHomeId");
	}
	
	@Override
	public List<HomeBean> selectTabs(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectTabById", params);
	}

	@Override
	public PosterBean getPoster() {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectPoster");
	}

}
