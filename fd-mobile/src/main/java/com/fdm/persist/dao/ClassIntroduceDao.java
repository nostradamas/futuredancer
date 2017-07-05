package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.ClassIntroduceBean;


/**
 * 少儿舞蹈课程介绍数据层
 * @author nostr
 *
 */
public interface ClassIntroduceDao {

	int selectTotal(Map<String, Object> params);

	List<ClassIntroduceBean> selectClassIntroducesInPage(Map<String, Object> params);

	ClassIntroduceBean selectClassIntroduceById(String id);

	int insert(ClassIntroduceBean bean);

	int update(ClassIntroduceBean bean);

	int deleteById(String id);

}
