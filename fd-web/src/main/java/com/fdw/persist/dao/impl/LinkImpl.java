package com.fdw.persist.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fdw.model.LinkBean;
import com.fdw.persist.dao.LinkDao;


@Repository
public class LinkImpl extends BaseImpl  implements LinkDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".LinkMapper";

	@Override
	public List<LinkBean> selectLinks() {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectLinks");
	}

	@Override
	public int selectTotal() {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal");
	}
	

}
