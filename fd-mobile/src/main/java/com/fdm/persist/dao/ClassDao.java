package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.ClassBean;



/**
 * 课程数据层
 * @author nostr
 *
 */
public interface ClassDao {


	List<ClassBean> selectClassesInPage(Map<String, Object> params);

	int selectTotal(Map<String, Object> params);

	ClassBean selectClassById(String cid);

	int insert(ClassBean bean);

	int update(ClassBean bean);

	int deleteById(String id);

	
}
