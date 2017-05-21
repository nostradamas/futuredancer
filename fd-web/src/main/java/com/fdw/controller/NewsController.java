package com.fdw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdw.controller.res.ListResult;
import com.fdw.controller.res.ResNewsList;
import com.fdw.model.NewsCategoryBean;
import com.fdw.service.NewsService;
import com.fdw.util.NumUtil;
import com.fdw.util.StringUtil;

@Controller
public class NewsController {

	@Autowired
	NewsService newsServiceImpl;
	
	/**
	 * 获取新闻列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/news/getNews")
	@ResponseBody
	public ListResult<?> getNews(HttpServletRequest request, HttpServletResponse response) {
		ListResult<ResNewsList> result = new ListResult<ResNewsList>();
		String cid =  StringUtil.toString(request.getParameter("cid"), null);// 按时间排序
		int page = NumUtil.toInt(request.getParameter("page"), 1);
		int pageSize = NumUtil.toInt(request.getParameter("pageSize"), 10);
		result = newsServiceImpl.getNewsList(page, pageSize, cid);
		return result;
	}
	
	/**
	 * 获取分类列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/news/getCategories")
	@ResponseBody
	public ListResult<?> getCategories(HttpServletRequest request, HttpServletResponse response) {
		ListResult<NewsCategoryBean> result = new ListResult<NewsCategoryBean>();
		List<NewsCategoryBean> list = newsServiceImpl.getNewsCategory();
		result.setData(list);
		return result;
	}
}
