package com.fdw.persist.dao.impl;

import org.springframework.stereotype.Repository;

import com.fdw.model.FooterBean;
import com.fdw.persist.dao.FooterDao;


@Repository
public class FooterImpl extends BaseImpl  implements FooterDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".FooterMapper";

	@Override
	public FooterBean selectFooter() {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectFooter");
	}
	

}
