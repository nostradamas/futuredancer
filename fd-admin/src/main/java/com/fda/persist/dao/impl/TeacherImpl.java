package com.fda.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fda.model.TeacherBean;
import com.fda.persist.dao.TeacherDao;

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

	@Override
	public TeacherBean selectTeacherById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTeacherById", id);
	}

	@Override
	public int insert(TeacherBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(TeacherBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}
	

}
