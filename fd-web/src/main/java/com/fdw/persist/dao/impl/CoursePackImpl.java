package com.fdw.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdw.model.CoursePackBean;
import com.fdw.persist.dao.CoursePackDao;


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


}
