package com.fda.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fda.model.StudentBean;
import com.fda.persist.dao.StudentDao;


@Repository
public class StudentImpl extends BaseImpl  implements StudentDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".StudentMapper";

	@Override
	public List<StudentBean> selectStudentsInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectStudentsInPage",params);
	}

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public StudentBean selectStudentById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectStudentById", id);
	}

	@Override
	public int insert(StudentBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(StudentBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}
	

}
