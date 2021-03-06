package com.fda.persist.dao.impl;

import org.springframework.stereotype.Repository;

import com.fda.model.AboutusBean;
import com.fda.persist.dao.AboutusDao;


@Repository
public class AboutusImpl extends BaseImpl  implements AboutusDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".AboutusMapper";

	@Override
	public AboutusBean selectAboutus() {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectAboutus");
	}

	@Override
	public int update(AboutusBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}
	

}
