package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.CoursePackBean;

/**
 * 课程包数据层
 * @author nostr
 *
 */
public interface CoursePackDao {

	int selectTotal(Map<String, Object> params);

	List<CoursePackBean> selectCoursePacksInPage(Map<String, Object> params);

	CoursePackBean selectCoursePackById(String id);

	int insert(CoursePackBean bean);

	int update(CoursePackBean bean);

	int deleteById(String id);


}
