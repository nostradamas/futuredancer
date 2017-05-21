package com.fdw.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdw.model.HomeBean;
import com.fdw.model.PosterBean;

/**
 * 主页数据层
 * @author nostr
 *
 */
public interface HomeDao {

	HomeBean selectHomeBean(String hid);

	String selectHomeId();

	List<HomeBean> selectTabs(Map<String, Object> params);

	PosterBean getPoster();
	
}
