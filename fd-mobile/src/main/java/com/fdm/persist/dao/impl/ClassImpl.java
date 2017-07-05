package com.fdm.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdm.model.ClassBean;
import com.fdm.persist.dao.ClassDao;

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
	public int insert(ClassBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(ClassBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}
	

}
