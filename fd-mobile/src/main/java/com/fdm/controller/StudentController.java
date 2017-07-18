package com.fdm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdm.controller.res.ListResult;
import com.fdm.controller.resmodel.ResStudentBean;
import com.fdm.service.StudentService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.NumUtil;
import com.fdm.util.StringUtil;

/**
 * 学生controller层
 * 
 * @author nostr
 *
 */

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentServiceImpl;

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
	public ListResult<ResStudentBean> getStudentLists(HttpServletRequest request, HttpServletResponse response) {
		ListResult<ResStudentBean> result = new ListResult<>();
		try {
			response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
			Integer page = NumUtil.toInt(request.getParameter("page"), 0);
			Integer pageSize = NumUtil.toInt(request.getParameter("pageSize"), 6);// 默认显示6个
			String homeId = StringUtil.toString(request.getParameter("homeId"), null);
			result = studentServiceImpl.getStudents(page, pageSize, homeId);
		} catch (ServiceException e) {
			result.setFlag(false);
			result.setMsg(e.getServiceMsg());
		}
		return result;
	}

}
