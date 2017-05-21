package com.fdw.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdw.model.ClassBean;
import com.fdw.model.ClassIntroduceBean;
import com.fdw.persist.dao.ClassDao;

@Repository
public class ClassImpl extends BaseImpl  implements ClassDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".ClassMapper";

	@Override
	public List<ClassBean> selectClassesInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectClassesInPage",params);
	}

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public ClassBean selectClassById(String cid) {
		return  sqlSessionTemplate.selectOne(NAME_SPACE + ".selectClassById", cid);
	}
	
	@Override
	public List<ClassIntroduceBean> selectClassMenus(String tabId) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectClassMenus", tabId);
	}

	

}
