package com.fdm.persist.dao;

import com.fdm.model.FooterBean;


/**
 * 底部数据层
 * @author nostr
 *
 */
public interface FooterDao {

	FooterBean selectFooter();

	int update(FooterBean bean);

	int deleteById(String id);

}
