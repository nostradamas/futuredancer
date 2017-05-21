package com.fdw.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.fdw.model.NewsBean;
import com.fdw.service.HomeService;
import com.fdw.service.NewsService;
import com.fdw.util.staticHtml.TemplateUtils;

@Controller
public class NewsDetailController {

	@Autowired
	HomeService homeServiceImpl;

	@Autowired
	NewsService newsServiceImpl;
	
	private FreeMarkerConfigurer config;

	private TemplateUtils templateUtils;
	
	

	@RequestMapping("/news/{newscode}")
	public ModelAndView initCreate(HttpServletRequest request,@PathVariable String newscode) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("SERVER", request.getContextPath());
		
		String homeId = homeServiceImpl.getHomeId();
		modelAndView.addObject("homeId", homeId);
		
		NewsBean newsBean = newsServiceImpl.getNewsByCode(newscode);
		System.out.println(newsBean);
		if(newsBean != null) {
			Timestamp date = newsBean.getCreateTime();
			if(date == null) {
				newsBean.setDateStr(sdf.format(new Date()));
			} else {
				newsBean.setDateStr(sdf.format(date));
			}
		}
		modelAndView.addObject("newsBean", newsBean);
		modelAndView.setViewName("news_detail");
		return modelAndView;
	}

	public FreeMarkerConfigurer getConfig() {
		return config;
	}

	public void setConfig(FreeMarkerConfigurer config) {
		this.config = config;
	}

	public TemplateUtils getTemplateUtils() {
		return templateUtils;
	}

	public void setTemplateUtils(TemplateUtils templateUtils) {
		this.templateUtils = templateUtils;
	}

}
