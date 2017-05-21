package com.fdw.persist.dao;

import java.util.List;

import com.fdw.model.IndexContentBean;

/**
 * 二级菜单数据层
 * @author nostr
 *
 */
public interface IndexContentDao {


	List<IndexContentBean> selectIndexContents(String homeId, int type);
	
}
