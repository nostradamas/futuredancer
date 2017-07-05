package com.fdm.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdm.model.CoursePackBean;
import com.fdm.persist.dao.CoursePackDao;

@Repository
public class CoursePackImpl extends BaseImpl  implements CoursePackDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".CoursePackMapper";

	@Override
	public List<CoursePackBean> selectCoursePacksInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectCoursePacksInPage",params);
	}

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public CoursePackBean selectCoursePackById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectCoursePackById", id);
	}

	@Override
	public int insert(CoursePackBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(CoursePackBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}
	

}
