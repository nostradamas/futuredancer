package com.fdm.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdm.model.ClassIntroduceBean;
import com.fdm.persist.dao.ClassIntroduceDao;

@Repository
public class ClassIntroduceImpl extends BaseImpl  implements ClassIntroduceDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".ClassIntroduceMapper";

	@Override
	public List<ClassIntroduceBean> selectClassIntroducesInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectClassIntroducesInPage",params);
	}

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public ClassIntroduceBean selectClassIntroduceById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectClassIntroduceById", id);
	}

	@Override
	public int insert(ClassIntroduceBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(ClassIntroduceBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}
	

}
