package com.fdw.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdw.model.AboutusBean;
import com.fdw.model.ClassBean;
import com.fdw.model.ClassIntroduceBean;
import com.fdw.model.HomeBean;
import com.fdw.model.NewsBean;
import com.fdw.model.PageContentBean;
import com.fdw.service.AboutusService;
import com.fdw.service.ClassService;
import com.fdw.service.HomeService;
import com.fdw.service.NewsService;
import com.fdw.util.NumUtil;
import com.fdw.util.StringUtil;

@Controller
public class PageController {

	@Autowired
	HomeService homeServiceImpl;
	@Autowired
	ClassService classServiceImpl;
	@Autowired
	NewsService newsServiceImpl;
	@Autowired
	AboutusService aboutusServiceImpl;


	@RequestMapping("/")
	public ModelAndView toIndex() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		String homeId = homeServiceImpl.getHomeId();
		if (homeId != null) {
			mv.addObject("homeId", homeId);
		}
		return mv;
	}

	@RequestMapping("/home/toAboutusMain")
	public ModelAndView aboutus() {
		ModelAndView mv = new ModelAndView();
		String homeId = homeServiceImpl.getHomeId();
		if (homeId != null) {
			mv.addObject("homeId", homeId);
		}
		AboutusBean aboutus = aboutusServiceImpl.getContent();
		if (aboutus != null) {
			List<PageContentBean> cultures = aboutusServiceImpl.getCultures(aboutus.getAid());
			mv.addObject("aboutusBean", aboutus);
			mv.addObject("cultures", cultures);
		}
		mv.setViewName("subhome/aboutus");
		return mv;
	}

	@RequestMapping("/home/toTeachersMain")
	public ModelAndView teachers(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String homeId = homeServiceImpl.getHomeId();
		String targetId = StringUtil.toString(request.getParameter("targetId"), null);
		mv.addObject("targetId", targetId);
		if (homeId != null) {
			mv.addObject("homeId", homeId);
		}
		mv.setViewName("subhome/teachers");
		return mv;
	}

	@RequestMapping("/home/toVideoPlayMain")
	public ModelAndView toVideoPlay(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String cid = StringUtil.toString(request.getParameter("cid"), null);
		String homeId = homeServiceImpl.getHomeId();
		if (homeId != null) {
			mv.addObject("homeId", homeId);
		}
		if (!StringUtil.checkEmpty(cid) && !"".equals(cid)) {
			ClassBean classBean = classServiceImpl.getClassById(cid);
			mv.addObject("classBean", classBean);
		}
		mv.setViewName("subhome/video_play");
		return mv;
	}

	@RequestMapping("/subHome/toTeachersMain")
	public ModelAndView subteachers(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String homeId = StringUtil.toString(request.getParameter("hid"), null);
		String tabId = StringUtil.toString(request.getParameter("tabId"), null);
		if (!StringUtil.checkEmpty(homeId)) {
			HomeBean homeBean = homeServiceImpl.getHomeBean(homeId);
			mv.addObject("homeBean", homeBean);
		}
		if (!StringUtil.checkEmpty(tabId)) {
			mv.addObject("tabId", tabId);// 当前页id
		}
		mv.setViewName("item/teachers");
		return mv;
	}

	@RequestMapping("/home/toStudentsMain")
	public ModelAndView students(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String homeId = homeServiceImpl.getHomeId();
		if (homeId != null) {
			mv.addObject("homeId", homeId);
		}
		String targetId = StringUtil.toString(request.getParameter("targetId"), null);
		mv.addObject("targetId", targetId);
		mv.setViewName("subhome/students");
		return mv;
	}

	@RequestMapping("/subHome/toStudentsMain")
	public ModelAndView artteachers(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String homeId = StringUtil.toString(request.getParameter("hid"), null);
		String tabId = StringUtil.toString(request.getParameter("tabId"), null);
		String targetId = StringUtil.toString(request.getParameter("targetId"), null);
		mv.addObject("targetId", targetId);
		if (!StringUtil.checkEmpty(homeId)) {
			HomeBean homeBean = homeServiceImpl.getHomeBean(homeId);
			mv.addObject("homeBean", homeBean);
		}
		if (!StringUtil.checkEmpty(tabId)) {
			mv.addObject("tabId", tabId);// 当前页id
		}
		mv.setViewName("item/students");
		return mv;
	}

	@RequestMapping("/subHome/toClassesMain")
	public ModelAndView toClassess(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String homeId = StringUtil.toString(request.getParameter("hid"), null);
		String tabId = StringUtil.toString(request.getParameter("tabId"), null);
		String menuId = StringUtil.toString(request.getParameter("menuId"), null);
		int type = NumUtil.toInt(request.getParameter("type"), 0);
		if (!StringUtil.checkEmpty(homeId)) {
			HomeBean homeBean = homeServiceImpl.getHomeBean(homeId);
			mv.addObject("homeBean", homeBean);
		}
		if (!StringUtil.checkEmpty(tabId)) {
			mv.addObject("tabId", tabId);// 当前页id
		}
		if (type == 2) {// 少儿舞蹈
			// 获取第一个舞蹈内容
			List<ClassIntroduceBean> list = new ArrayList<>();
			if (!StringUtil.checkEmpty(tabId)) {
				list = classServiceImpl.getClassMenus(tabId);
			}
			if (list != null && list.size() > 0) {
				mv.addObject("classMenu", list);
				if (!StringUtil.checkEmpty(menuId)) {
					mv.addObject("menuId", menuId);
				} else {
					mv.addObject("menuId", list.get(0).getCid());
				}
			}
			mv.setViewName("item/childClasses");
		} else {
			mv.setViewName("item/classes");

		}
		return mv;
	}

	@RequestMapping("/home/toVideosMain")
	public ModelAndView videos() {
		ModelAndView mv = new ModelAndView();
		String homeId = homeServiceImpl.getHomeId();
		if (homeId != null) {
			mv.addObject("homeId", homeId);
		}
		// List<BannerBean> list = homeServiceImpl.getBanners("2");// 获取视频
		// System.out.println(list);
		// if(list != null && list.size() > 0) {
		// mv.addObject("videolist", list);
		// }
		mv.setViewName("subhome/videos");
		return mv;
	}

	@RequestMapping("/home/toNewsMain")
	public ModelAndView news() {
		ModelAndView mv = new ModelAndView();
		String homeId = homeServiceImpl.getHomeId();
		if (homeId != null) {
			mv.addObject("homeId", homeId);
		}
		mv.setViewName("subhome/news");
		return mv;
	}

	/**
	 * 招生
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/toRecruitMain")
	public ModelAndView toRecruitMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String homeId = homeServiceImpl.getHomeId();
		mv.addObject("homeId", homeId);
		mv.setViewName("subhome/recruit");
		return mv;
	}

	/**
	 * 每月主题
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/toThemeMain")
	public ModelAndView toThemeMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String homeId = homeServiceImpl.getHomeId();
		mv.addObject("homeId", homeId);
		mv.setViewName("subhome/month_theme");
		return mv;
	}
	
	

	@RequestMapping("/toNewsDetailMain")
	public ModelAndView toNewsDetailMain(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ModelAndView mv = new ModelAndView();
		String nid = StringUtil.toString(request.getParameter("nid"), null);
		String homeId = homeServiceImpl.getHomeId();
		if (homeId != null) {
			mv.addObject("homeId", homeId);
		}
		if (!StringUtil.checkEmpty(nid) && !"".equals(nid)) {
			NewsBean newsBean = newsServiceImpl.getNewsById(nid);
			newsBean.setDateStr(sdf.format(newsBean.getCreateTime()));
			mv.addObject("newsBean", newsBean);
		}
		mv.setViewName("news_detail");
		return mv;
	}


}
