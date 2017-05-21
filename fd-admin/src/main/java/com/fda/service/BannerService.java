package com.fda.service;

import java.util.List;

import com.fda.controller.res.ListResult;
import com.fda.model.BannerBean;
import com.fda.model.BannerCodeBean;


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
