package com.fdw.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdw.model.ClassIntroduceBean;



/**
 * 少儿舞蹈课程介绍数据层
 * @author nostr
 *
 */
public interface ClassIntroduceDao {

	List<ClassIntroduceBean> selectClassIntroducesByTabId(Map<String, Object> params);

}
