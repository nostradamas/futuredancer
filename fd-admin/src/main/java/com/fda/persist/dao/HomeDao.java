package com.fda.persist.dao;

import java.util.List;
import java.util.Map;

import com.fda.model.HomeBean;


/**
 * 主页数据层
 * @author nostr
 *
 */
public interface HomeDao {

	int selectTotal(Map<String, Object> params);

	List<HomeBean> selectHomeInPage(Map<String, Object> params);

	HomeBean selectHomeById(String id);

	int insert(HomeBean bean);

	int update(HomeBean bean);

	int deleteById(String id);

}
