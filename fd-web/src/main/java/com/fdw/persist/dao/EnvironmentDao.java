package com.fdw.persist.dao;

import java.util.List;

import com.fdw.model.EnvironmentBean;

/**
 * 环境 数据层
 * @author nostr
 *
 */
public interface EnvironmentDao {
	
	List<EnvironmentBean> selectEnvironments(int type);
}
