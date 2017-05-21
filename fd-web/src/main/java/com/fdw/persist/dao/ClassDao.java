package com.fdw.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdw.model.ClassBean;
import com.fdw.model.ClassIntroduceBean;

/**
 * 课程数据层
 * @author nostr
 *
 */
public interface ClassDao {


	List<ClassBean> selectClassesInPage(Map<String, Object> params);

	int selectTotal(Map<String, Object> params);

	ClassBean selectClassById(String cid);

	List<ClassIntroduceBean> selectClassMenus(String tabId);
}
