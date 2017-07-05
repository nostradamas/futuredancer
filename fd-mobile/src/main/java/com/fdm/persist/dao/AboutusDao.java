package com.fdm.persist.dao;

import com.fdm.model.AboutusBean;

/**
 * 关于我们数据层
 * @author nostr
 *
 */
public interface AboutusDao {

	AboutusBean selectAboutus();

	int update(AboutusBean bean);

}
