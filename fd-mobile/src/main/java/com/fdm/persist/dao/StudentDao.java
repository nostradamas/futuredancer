package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.QuestionBean;
import com.fdm.model.StudentBean;



/**
 * 学生数据层
 * @author nostr
 *
 */
public interface StudentDao {


	List<StudentBean> selectStudentsInPage(Map<String, Object> params);

	int selectTotal(Map<String, Object> params);

	StudentBean selectStudentById(String id);

	int insertQuestion(QuestionBean bean);

}
