package com.fdw.persist.dao;

import java.util.List;

import com.fdw.model.BannerBean;

/**
 * banner数据层
 * @author nostr
 *
 */
public interface BannerDao {


	List<BannerBean> selectBanners(String code);
	
}
