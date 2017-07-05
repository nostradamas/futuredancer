package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.TeacherBean;
import com.fdm.model.TeacherHomeBean;


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

	int selectHomeCount(String teacherId);

	int deleteTeacherHome(String teacherId);

	int insertTeacherHome(List<TeacherHomeBean> data);

	List<TeacherHomeBean> selectTeacherHome(String teacherId);

	
}
