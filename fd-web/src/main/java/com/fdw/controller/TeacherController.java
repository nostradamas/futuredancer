package com.fdw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdw.controller.res.ListResult;
import com.fdw.model.TeacherBean;
import com.fdw.service.TeacherService;
import com.fdw.util.NumUtil;
import com.fdw.util.StringUtil;

@Controller
public class TeacherController {

	@Autowired
	TeacherService teacherServiceImpl;
	
	/**
	 * 获取教师列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/teacher/getTeachers")
	@ResponseBody
	public ListResult<?> getTeachers(HttpServletRequest request, HttpServletResponse response) {
		ListResult<TeacherBean> result = new ListResult<TeacherBean>();
		String homeId =  StringUtil.toString(request.getParameter("homeId"), null);// 按时间排序
		int type = NumUtil.toInt(request.getParameter("type"), 0);
		int page = NumUtil.toInt(request.getParameter("page"), 1);
		int atHome = NumUtil.toInt(request.getParameter("atHome"), 0);// 默认不显示
		int pageSize = NumUtil.toInt(request.getParameter("pageSize"), 10);
		result = teacherServiceImpl.getTeachers(page, pageSize, homeId, type, atHome);
		return result;
	}
	
}
