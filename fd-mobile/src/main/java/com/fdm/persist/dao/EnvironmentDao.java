package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.EnvironmentBean;

/**
 * 环境 数据层
 * 
 * @author nostr
 *
 */
public interface EnvironmentDao {

	List<EnvironmentBean> selectEnvironmentsInPage(Map<String, Object> params);

	int selectTotal(Map<String, Object> params);

	EnvironmentBean selectEnvironmentById(String id);

	int insert(EnvironmentBean bean);

	int update(EnvironmentBean bean);

	int deleteById(String id);

}
