package com.fdm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.constants.RescodeConstants;
import com.fdm.controller.req.BaseDataTablesReq;
import com.fdm.controller.req.EditLinkDetailParam;
import com.fdm.controller.req.GetBaseDetailParam;
import com.fdm.controller.res.BaseResult;
import com.fdm.controller.res.DataTablesResult;
import com.fdm.controller.res.ListResult;
import com.fdm.model.LinkBean;
import com.fdm.service.LinkService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.QiniuUtil;
import com.fdm.util.StringUtil;

/**
 * 友情链接controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/link")
public class LinkController {

	@Autowired
	LinkService linkServiceImpl;
	
	/**
	 * 友情链接管理
	 * @return
	 */
	@RequestMapping("/toLinkMain")
	public ModelAndView toLinkMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/link/linkMain");
		return mv;
	}
	
	/**
	 * 获取友情链接列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getLinkLists")
    @ResponseBody
    public DataTablesResult<LinkBean> getLinkLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<LinkBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        ListResult<LinkBean> res = linkServiceImpl.getLinkLists(start, length);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	
	@RequestMapping("/toLinkDetail")
	public ModelAndView toLinkDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		LinkBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new LinkBean();
		} else {
			bean = linkServiceImpl.getLinkById(param.getId());
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("link/linkDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/linkSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditLinkDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			LinkBean bean = new LinkBean();
			bean.setLid(param.getLid());
			bean.setLinkName(param.getLinkName());
			bean.setLinkUrl(param.getLinkUrl());
			bean.setImg(param.getImg());
			bean.setSort(param.getSort());
			boolean flag = linkServiceImpl.saveLink(bean);
			if (flag) {
				result.setRescode(RescodeConstants.getInstance().get("success").getCode());
				result.setMsg(RescodeConstants.getInstance().get("success").getMsg());
			}
		} catch (ServiceException e) {
			result.setRescode(e.getServiceCode());
			result.setMsg(e.getServiceMsg());
		}

		return result;
	}

	@RequestMapping("/linkDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = linkServiceImpl.deleteLinkById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setMsg(e.getServiceMsg());
			res.setRescode(e.getServiceCode());
		}
		return res;
	}
	
}
