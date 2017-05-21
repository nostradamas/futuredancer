package com.fdw.persist.dao;

import java.util.List;

import com.fdw.model.LinkBean;



/**
 * 超链接数据层
 * @author nostr
 *
 */
public interface LinkDao {

	List<LinkBean> selectLinks();

	int selectTotal();

}
