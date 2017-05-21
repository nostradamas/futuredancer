package com.fdw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdw.controller.res.ListResult;
import com.fdw.model.ClassBean;
import com.fdw.service.ClassService;
import com.fdw.util.NumUtil;
import com.fdw.util.StringUtil;

@Controller
public class ClassController {

	@Autowired
	ClassService classServiceImpl;
	
	/**
	 * 获取课程列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/class/getClasses")
	@ResponseBody
	public ListResult<?> getClasses(HttpServletRequest request, HttpServletResponse response) {
		ListResult<ClassBean> result = new ListResult<ClassBean>();
		String homeId =  StringUtil.toString(request.getParameter("homeId"), null);// 按时间排序
		int page = NumUtil.toInt(request.getParameter("page"), 1);
		int pageSize = NumUtil.toInt(request.getParameter("pageSize"), 10);
		result = classServiceImpl.getClasses(page, pageSize, homeId);
		return result;
	}
	
	
	
}
