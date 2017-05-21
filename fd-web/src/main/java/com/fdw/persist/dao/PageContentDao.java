package com.fdw.persist.dao;

import java.util.List;

import com.fdw.model.PageContentBean;

/**
 * 项目内容页数据层
 * @author nostr
 *
 */
public interface PageContentDao {


	List<PageContentBean> selectPageContents(String homeId);

}
