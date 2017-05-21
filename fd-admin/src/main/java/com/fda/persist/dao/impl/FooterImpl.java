package com.fda.persist.dao.impl;

import org.springframework.stereotype.Repository;

import com.fda.model.FooterBean;
import com.fda.persist.dao.FooterDao;

@Repository
public class FooterImpl extends BaseImpl  implements FooterDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".FooterMapper";

	@Override
	public FooterBean selectFooter() {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectFooter");
	}

	@Override
	public int update(FooterBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}
	

}
