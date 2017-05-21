package com.fdw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fdw.controller.res.ListResult;
import com.fdw.controller.res.ObjectResult;
import com.fdw.model.BannerBean;
import com.fdw.model.EnvironmentBean;
import com.fdw.model.FooterBean;
import com.fdw.model.HomeBean;
import com.fdw.model.IndexContentBean;
import com.fdw.model.PageContentBean;
import com.fdw.model.PosterBean;
import com.fdw.model.StepBean;
import com.fdw.model.TabBean;
import com.fdw.service.HomeService;
import com.fdw.util.NumUtil;
import com.fdw.util.StringUtil;

@Controller
public class HomeController {

	@Autowired
	HomeService homeServiceImpl;
	
	/**
	 * 导航进入的子主页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/subHome/toIndexMain")
	public ModelAndView toIndex(HttpServletRequest request) {
		String hid = StringUtil.toString(request.getParameter("hid"), null);
		ModelAndView mv = new ModelAndView();
		if (!StringUtil.checkEmpty(hid)) {
			HomeBean home = homeServiceImpl.getHomeBean(hid);
			mv.addObject("homeBean", home);
			if(home.getIsLeaf()!=1){//舞蹈艺考
				mv.setViewName("home/dance_index");
				return mv;
			}
		}
		mv.setViewName("home/home_index");

		return mv;
	}	
	
	
	/**
	 * 项目详情页
	 * @param request
	 * @return
	 */
	@RequestMapping("/subHome/toItemMain")
	public ModelAndView toItemMain(HttpServletRequest request) {
		String hid = StringUtil.toString(request.getParameter("hid"), null);
		ModelAndView mv = new ModelAndView();
		if (!StringUtil.checkEmpty(hid)) {
			HomeBean home = homeServiceImpl.getHomeBean(hid);
			if(home.getIsLeaf()==1){
				HomeBean parentHome =  homeServiceImpl.getHomeBean(home.getParentId());
				mv.addObject("homeBean", parentHome);
				mv.addObject("subHomeBean", home);

			} else {
				mv.addObject("homeBean", home);
			}
		}
		mv.setViewName("home/item_index");

		return mv;
	}	
	
	
	
	/**
	 * 首页导航
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/home/getHomeTabs")
	@ResponseBody
	public ListResult<?> getHomeTabs(HttpServletRequest request, HttpServletResponse response) {
		ListResult<HomeBean> result = new ListResult<HomeBean>();
		String homeId = StringUtil.toString(request.getParameter("homeId"), null);
		int showChild = NumUtil.toInt(request.getParameter("showChild"), 0);
		String thisId = StringUtil.toString(request.getParameter("thisId"), null);
		List<HomeBean> homes = homeServiceImpl.getTabs(homeId,showChild, thisId);
		result.setData(homes);
		result.setTotalSize(homes.size());
		return result;
	}


	/**
	 * 获取首页banner
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/home/getBanners")
	@ResponseBody
	public ListResult<?> getBanners(HttpServletRequest request, HttpServletResponse response) {
		ListResult<BannerBean> result = new ListResult<BannerBean>();
		String code = StringUtil.toString(request.getParameter("code"), null);
		List<BannerBean> list = new ArrayList<>();
		if (!StringUtil.checkEmpty(code)) {
			list = homeServiceImpl.getBanners(code);
		}
		result.setData(list);
		result.setTotalSize(list.size());
		return result;
	}

	/**
	 * 获取子页面内容
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/home/getIndexContents")
	@ResponseBody
	public ListResult<?> getIndexContents(HttpServletRequest request, HttpServletResponse response) {
		ListResult<IndexContentBean> result = new ListResult<IndexContentBean>();
		String homeId = StringUtil.toString(request.getParameter("homeId"), null);
		List<IndexContentBean> list = new ArrayList<>();
		if (!StringUtil.checkEmpty(homeId)) {
			list = homeServiceImpl.getIndexContents(homeId, 0);
		}
		result.setData(list);
		result.setTotalSize(list.size());
		return result;
	}
	/**
	 * 获取项目页面内容
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/home/getItemContents")
	@ResponseBody
	public ListResult<?> getItemContents(HttpServletRequest request, HttpServletResponse response) {
		ListResult<PageContentBean> result = new ListResult<PageContentBean>();
		String homeId = StringUtil.toString(request.getParameter("homeId"), null);
		List<PageContentBean> list = new ArrayList<>();
		if (!StringUtil.checkEmpty(homeId)) {
			list = homeServiceImpl.getItemContents(homeId);
		}
		result.setData(list);
		result.setTotalSize(list.size());
		return result;
	}
	/**
	 * 获取子页面导航
	 * 
	 * @param request 
	 * @param response
	 * @return
	 */
	@RequestMapping("/home/getSubTabs")
	@ResponseBody
	public ListResult<?> getSubTabs(HttpServletRequest request, HttpServletResponse response) {
		ListResult<TabBean> result = new ListResult<TabBean>();
		String homeId = StringUtil.toString(request.getParameter("homeId"), null);
		String tid = StringUtil.toString(request.getParameter("tid"), null);
		List<TabBean> list = new ArrayList<>();
		List<IndexContentBean> res = homeServiceImpl.getIndexContents(homeId, 3);
		if(res!=null && res.size() > 0){
			for(IndexContentBean cat : res) {
				TabBean tab = new TabBean();
				tab.setTid(cat.getMid());
				tab.setName(cat.getName());
				tab.setIcon(cat.getIcon());
				if(!StringUtil.checkEmpty(tid) && tid.equals(cat.getMid())){
					tab.setOn(true);
				}
				tab.setType(NumUtil.toInt(cat.getContentType(),0));
				tab.setUrl(cat.getUrl());
				list.add(tab);
			}
		}
		result.setData(list);
		result.setTotalSize(list.size());
		return result;
	}
	
	@RequestMapping("/home/getEnvironments")
	@ResponseBody
	public ListResult<?> getEnvironments(HttpServletRequest request, HttpServletResponse response) {
		ListResult<EnvironmentBean> result = new ListResult<EnvironmentBean>();
		int type = NumUtil.toInt(request.getParameter("type"), 1);
		List<EnvironmentBean> res = homeServiceImpl.getEnvironments(type);
		result.setData(res);
		result.setTotalSize(res.size());
		return result;
	}
	
	/**
	 * 获取footer
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/home/getFooter")
	@ResponseBody
	public ObjectResult<?> getFooter(HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<FooterBean> result = new ObjectResult<FooterBean>();
		FooterBean footer = homeServiceImpl.getFooer();
		result.setData(footer);
		return result;
	}
	

	@RequestMapping("/home/getSteps")
	@ResponseBody
	public ListResult<?> getSteps(HttpServletRequest request, HttpServletResponse response) {
		ListResult<StepBean> result = new ListResult<StepBean>();
		String homeId = StringUtil.toString(request.getParameter("hid"), null);
		List<StepBean> res = homeServiceImpl.getSteps(homeId);
		result.setData(res);
		result.setTotalSize(res.size());
		return result;
	}
	
	@RequestMapping("/home/getPoster")
	@ResponseBody
	public ObjectResult<?> getPoster(HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<PosterBean> result = new ObjectResult<PosterBean>();
		PosterBean res = homeServiceImpl.getPoster();
		result.setData(res);
		return result;
	}
	
	
}
