package com.fdw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdw.controller.res.ListResult;
import com.fdw.model.StudentBean;
import com.fdw.service.StudentService;
import com.fdw.util.NumUtil;
import com.fdw.util.StringUtil;

@Controller
public class StudentController {

	@Autowired
	StudentService studentServiceImpl;
	
	/**
	 * 获取学员列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/student/getStudents")
	@ResponseBody
	public ListResult<?> getStudents(HttpServletRequest request, HttpServletResponse response) {
		ListResult<StudentBean> result = new ListResult<StudentBean>();
		String homeId =  StringUtil.toString(request.getParameter("homeId"), null);// 按时间排序
		int page = NumUtil.toInt(request.getParameter("page"), 1);
		int pageSize = NumUtil.toInt(request.getParameter("pageSize"), 10);
		int atHome = NumUtil.toInt(request.getParameter("atHome"), 0);// 默认不显示
		result = studentServiceImpl.getStudents(page, pageSize, homeId, atHome);
		return result;
	}
	
	
}
