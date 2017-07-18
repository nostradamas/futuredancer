package com.fdm.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdm.model.TeacherBean;
import com.fdm.persist.dao.TeacherDao;

@Repository
public class TeacherImpl extends BaseImpl  implements TeacherDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".TeacherMapper";

	@Override
	public List<TeacherBean> selectTeachersInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectTeachersInPage",params);
	}

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}


}
