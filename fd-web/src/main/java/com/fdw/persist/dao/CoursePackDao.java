package com.fdw.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdw.model.CoursePackBean;


/**
 * 课程包数据层
 * @author nostr
 *
 */
public interface CoursePackDao {

	int selectTotal(Map<String, Object> params);

	List<CoursePackBean> selectCoursePacksInPage(Map<String, Object> params);


}
