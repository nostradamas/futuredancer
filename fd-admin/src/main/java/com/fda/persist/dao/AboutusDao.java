package com.fda.persist.dao;

import com.fda.model.AboutusBean;

/**
 * 关于我们数据层
 * @author nostr
 *
 */
public interface AboutusDao {

	AboutusBean selectAboutus();

	int update(AboutusBean bean);

}
