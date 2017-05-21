package com.fda.persist.dao;

import java.util.List;
import java.util.Map;

import com.fda.model.LinkBean;


/**
 * 超链接数据层
 * @author nostr
 *
 */
public interface LinkDao {

	List<LinkBean> selectLinksInPage(Map<String, Object> params);

	int selectTotal(Map<String, Object> params);

	LinkBean selectLinkById(String id);

	int insert(LinkBean bean);

	int update(LinkBean bean);

	int deleteById(String id);

}
