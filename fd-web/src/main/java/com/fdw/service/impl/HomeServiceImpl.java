package com.fdw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.model.BannerBean;
import com.fdw.model.EnvironmentBean;
import com.fdw.model.FooterBean;
import com.fdw.model.HomeBean;
import com.fdw.model.IndexContentBean;
import com.fdw.model.PageContentBean;
import com.fdw.model.PosterBean;
import com.fdw.model.StepBean;
import com.fdw.persist.dao.BannerDao;
import com.fdw.persist.dao.EnvironmentDao;
import com.fdw.persist.dao.FooterDao;
import com.fdw.persist.dao.HomeDao;
import com.fdw.persist.dao.IndexContentDao;
import com.fdw.persist.dao.PageContentDao;
import com.fdw.persist.dao.StepDao;
import com.fdw.service.HomeService;
import com.fdw.util.StringUtil;
@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	HomeDao homeImpl;
	
	@Autowired
	BannerDao bannerImpl;
			
	@Autowired
	IndexContentDao indexContentImpl;

	@Autowired
	PageContentDao pageContentImpl;
	
	@Autowired
	EnvironmentDao environmentImpl;
	
	@Autowired
	FooterDao footerImpl;

	@Autowired
	StepDao stepImpl;
	
	@Override
	public String getHomeId() {
		return homeImpl.selectHomeId();
	}
	
	@Override
	public HomeBean getHomeBean(String hid) {
		return homeImpl.selectHomeBean(hid);
	}

	@Override
	public List<HomeBean> getTabs(String homeId, int showChild, String thisId) {
		Map<String, Object> params = new HashMap<>();
		params.put("showChild", showChild);
		if(!StringUtil.checkEmpty(homeId)){
			params.put("homeId", homeId);
		}
		List<HomeBean> tabs = homeImpl.selectTabs(params);
		if(tabs != null && tabs.size() > 0 && thisId != null){
			HomeBean thisHome = homeImpl.selectHomeBean(thisId);
			if(thisHome!=null){
				String pid = thisHome.getParentId();
				for(HomeBean h : tabs){
					int active = 0;
					if(pid.equals(h.getHid()) || thisId.equals(h.getHid())){
						active = 1;
					}
					h.setActive(active);
				}
			}
			
		}
		return tabs;
	}

	@Override
	public List<BannerBean> getBanners(String code) {
		return bannerImpl.selectBanners(code);
	}

	@Override
	public List<IndexContentBean> getIndexContents(String homeId, int type) {
		return indexContentImpl.selectIndexContents(homeId,type);
	}

	@Override
	public List<PageContentBean> getItemContents(String homeId) {
		return pageContentImpl.selectPageContents(homeId);
	}

	@Override
	public List<EnvironmentBean> getEnvironments(int type) {
		return environmentImpl.selectEnvironments(type);
	}

	@Override
	public FooterBean getFooer() {
		return footerImpl.selectFooter();
	}

	@Override
	public List<StepBean> getSteps(String hid) {
		return stepImpl.selectSteps(hid);
	}

	@Override
	public PosterBean getPoster() {
		return homeImpl.getPoster();
	}


}
