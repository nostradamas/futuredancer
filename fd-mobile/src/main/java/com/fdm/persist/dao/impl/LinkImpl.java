package com.fdm.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdm.model.LinkBean;
import com.fdm.persist.dao.LinkDao;

@Repository
public class LinkImpl extends BaseImpl  implements LinkDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".LinkMapper";

	@Override
	public List<LinkBean> selectLinksInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectLinksInPage",params);
	}

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public LinkBean selectLinkById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectLinkById", id);
	}

	@Override
	public int insert(LinkBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(LinkBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}
	

}
