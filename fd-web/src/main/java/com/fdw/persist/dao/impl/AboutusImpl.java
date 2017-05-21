package com.fdw.persist.dao.impl;

import org.springframework.stereotype.Repository;

import com.fdw.model.AboutusBean;
import com.fdw.persist.dao.AboutusDao;

@Repository
public class AboutusImpl extends BaseImpl  implements AboutusDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".AboutusMapper";

	@Override
	public AboutusBean selectContent() {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectContent");
	}
	

}
