package com.fda.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fda.model.HomeBean;
import com.fda.persist.dao.HomeDao;


@Repository
public class HomeImpl extends BaseImpl  implements HomeDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".HomeMapper";

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public List<HomeBean> selectHomeInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectHomeInPage",params);
	}

	@Override
	public HomeBean selectHomeById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectHomeById", id);
	}

	@Override
	public int insert(HomeBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(HomeBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}
	

}
