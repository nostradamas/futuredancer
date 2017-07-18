package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.HomeBean;


/**
 * 主页数据层
 * @author nostr
 *
 */
public interface HomeDao {

	int selectTotal(Map<String, Object> params);

	List<HomeBean> selectHomeInPage(Map<String, Object> params);

	HomeBean selectHomeById(String id);

}
