package com.fdm.service;

import java.util.List;

import com.fdm.controller.res.ListResult;
import com.fdm.model.BannerBean;
import com.fdm.model.BannerCodeBean;


/**
 * Bannerservice层
 * 
 * @author nostr
 *
 */
public interface BannerService {


	ListResult<BannerBean> getLists(int start, int pageSize, int code, int type);

	BannerBean getBannerById(String bid);

	List<BannerCodeBean> getCodeLists();

	BannerCodeBean getBannerCodeById(String cid);

	boolean saveBanner(BannerBean bean);

	boolean deleteBannerById(String id);

	boolean saveBannerCode(BannerCodeBean bean);

	boolean deleteBannerCodeById(String id);

}
