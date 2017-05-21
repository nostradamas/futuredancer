package com.fdw.service;

import java.util.List;

import com.fdw.model.BannerBean;
import com.fdw.model.EnvironmentBean;
import com.fdw.model.FooterBean;
import com.fdw.model.HomeBean;
import com.fdw.model.IndexContentBean;
import com.fdw.model.PageContentBean;
import com.fdw.model.PosterBean;
import com.fdw.model.StepBean;

/**
 * 主页面service层
 * 
 * @author nostr
 *
 */
public interface HomeService {

	HomeBean getHomeBean(String hid);

	String getHomeId();

	List<HomeBean> getTabs(String homeId, int showChild, String thisId);
	
	List<BannerBean> getBanners(String code);

	List<IndexContentBean> getIndexContents(String homeId, int type);

	List<PageContentBean> getItemContents(String homeId);

	List<EnvironmentBean> getEnvironments(int type);

	FooterBean getFooer();

	List<StepBean> getSteps(String hid);

	PosterBean getPoster();

}
