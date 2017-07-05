package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.BannerBean;
import com.fdm.model.BannerCodeBean;



/**
 * banner数据层
 * @author nostr
 *
 */
public interface BannerDao {


	int selectTotal(Map<String, Object> params);

	List<BannerBean> selectBannersInPage(Map<String, Object> params);

	BannerBean selectBannerById(String bid);

	int insertBanner(BannerBean bean);
	
	int updateBanner(BannerBean bean);

	int deleteBannerById(String id);

	// bannerCode
	List<BannerCodeBean> selectBannerCode();
	
	BannerCodeBean selectBannerCodeById(String cid);

	int insertBannerCode(BannerCodeBean bean);

	int updateBannerCode(BannerCodeBean bean);

	int deleteBannerCodeById(String id);


}
