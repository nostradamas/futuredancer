package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.TeacherBean;


/**
 * 教师数据层
 * @author nostr
 *
 */
public interface TeacherDao {

	List<TeacherBean> selectTeachersInPage(Map<String, Object> params);

	int selectTotal(Map<String, Object> params);

}
