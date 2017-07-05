package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.IndexContentBean;



/**
 * 二级菜单数据层
 * @author nostr
 *
 */
public interface IndexContentDao {

	List<IndexContentBean> selectContentInPage(Map<String, Object> params);

	int selectContentTotal(Map<String, Object> params);

	IndexContentBean selectContentById(String id);

	int insert(IndexContentBean bean);

	int update(IndexContentBean bean);

	int deleteById(String id);
	
}
