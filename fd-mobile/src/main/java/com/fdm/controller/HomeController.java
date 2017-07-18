package com.fdm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdm.controller.res.ListResult;
import com.fdm.model.HomeBean;
import com.fdm.service.HomeService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.NumUtil;

/**
 * 主页controller层
 * 
 * @author nostr
 *
 */

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	HomeService homeServiceImpl;

	/**
	 * 获取主页列表
	 * 
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public ListResult<HomeBean> getHomeLists(HttpServletRequest request, HttpServletResponse response) {
		ListResult<HomeBean> result = new ListResult<>();
		response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
		try {
			int page = NumUtil.toInt(request.getParameter("page"), 1);
			int pageSize = NumUtil.toInt(request.getParameter("pageSize"), 10);
			result = homeServiceImpl.getHomeLists(page, pageSize);
		} catch (ServiceException e) {
			result.setFlag(false);
			result.setMsg(e.getServiceMsg());
		}
		return result;
	}

}
