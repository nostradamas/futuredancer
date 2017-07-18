package com.fdm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdm.controller.res.ListResult;
import com.fdm.controller.resmodel.ResTeacherBean;
import com.fdm.service.TeacherService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.NumUtil;

/**
 * 教师controller层
 * 
 * @author nostr
 *
 */

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherServiceImpl;

	/**
	 * 获取教师列表
	 * 
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public ListResult<ResTeacherBean> getTeacherLists(HttpServletRequest request, HttpServletResponse response) {
		ListResult<ResTeacherBean> result = new ListResult<>();
		response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
		try {
			Integer page = NumUtil.toInt(request.getParameter("page"), 0);
			Integer pageSize = NumUtil.toInt(request.getParameter("pageSize"), 6);// 默认显示6个
			int level = NumUtil.toInt(request.getParameter("level"), 0);//默认等级不查
			int targetId = NumUtil.toInt(request.getParameter("targetId"), 0);// 默认查不查所属类别
			result = teacherServiceImpl.getTeacherLists(page, pageSize, level, targetId);
		} catch (ServiceException e) {
			result.setFlag(false);
			result.setMsg(e.getServiceMsg());
		}
		return result;
	}
}
