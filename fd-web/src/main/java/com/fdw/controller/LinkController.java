package com.fdw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdw.controller.res.ListResult;
import com.fdw.model.LinkBean;
import com.fdw.service.LinkService;

/**
 * 友情链接controller层
 * 
 * @author nostr
 *
 */

@Controller
@RequestMapping("/link")
public class LinkController {

	@Autowired
	LinkService linkServiceImpl;

	/**
	 * 获取友情链接列表
	 * 
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getLinkLists")
	@ResponseBody
	public ListResult<LinkBean> getLinkLists(HttpServletRequest request, HttpServletResponse response) {
		ListResult<LinkBean> result = new ListResult<LinkBean>();
		result = linkServiceImpl.getLinkLists();
		return result;
	}

}
