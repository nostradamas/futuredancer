package com.fda.persist.dao;

import java.util.List;
import java.util.Map;

import com.fda.model.TeacherBean;


/**
 * 教师数据层
 * @author nostr
 *
 */
public interface TeacherDao {


	List<TeacherBean> selectTeachersInPage(Map<String, Object> params);

	int selectTotal(Map<String, Object> params);

	TeacherBean selectTeacherById(String id);

	int insert(TeacherBean bean);

	int update(TeacherBean bean);

	int deleteById(String id);

	
}
