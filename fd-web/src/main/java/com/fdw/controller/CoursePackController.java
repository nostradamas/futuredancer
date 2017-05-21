package com.fdw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdw.controller.res.ListResult;
import com.fdw.model.CoursePackBean;
import com.fdw.service.CoursePackService;
import com.fdw.util.NumUtil;
import com.fdw.util.StringUtil;

/**
 * 课程包controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/coursePack")
public class CoursePackController {

	@Autowired
	CoursePackService coursePackServiceImpl;

	/**
	 * 获取课程包列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getCoursePackLists")
    @ResponseBody
    public ListResult<?> getCoursePackLists(HttpServletRequest request, HttpServletResponse response) {
		ListResult<CoursePackBean> result = new ListResult<CoursePackBean>();
		String homeId =  StringUtil.toString(request.getParameter("homeId"), null);// 按时间排序
		int page = NumUtil.toInt(request.getParameter("page"), 1);
		int pageSize = NumUtil.toInt(request.getParameter("pageSize"), 10);
		result = coursePackServiceImpl.getCoursePackLists(page, pageSize, homeId);
		return result;
    }
	
}
