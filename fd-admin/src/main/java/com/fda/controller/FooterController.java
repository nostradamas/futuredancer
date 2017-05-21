package com.fda.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fda.constants.RescodeConstants;
import com.fda.controller.req.EditFooterDetailParam;
import com.fda.controller.res.BaseResult;
import com.fda.model.FooterBean;
import com.fda.service.FooterService;
import com.fda.service.exception.ServiceException;
import com.fda.util.QiniuUtil;

/**
 * 底部信息controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/footer")
public class FooterController {

	@Autowired
	FooterService footerServiceImpl;
	
	/**
	 * 友情链接管理
	 * @return
	 */
	@RequestMapping("/toFooterMain")
	public ModelAndView toFooterMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		FooterBean bean = footerServiceImpl.getFooter();
		mv.setViewName("/footer/footerDetail");
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.addObject("bean", bean);
		return mv;
	}
	
	@RequestMapping("/FooterSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditFooterDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			FooterBean bean = new FooterBean();
			bean.setFid(param.getFid());
			bean.setAddress(param.getAddress());
			bean.setAdultCode(param.getAdultCode());
			bean.setAdultCodeTitle(param.getAdultCodeTitle());
			bean.setChildCode(param.getChildCode());
			bean.setChildCodeTitle(param.getChildCodeTitle());
			bean.setCompany(param.getCompany());
			bean.setPhoneNum(param.getPhoneNum());
			bean.setRecord(param.getRecord());
			bean.setTelephone(param.getTelephone());
			bean.setTitle(param.getTitle());
			boolean flag = footerServiceImpl.saveFooter(bean);
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

	@RequestMapping("/FooterDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = footerServiceImpl.deleteFooterById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setMsg(e.getServiceMsg());
			res.setRescode(e.getServiceCode());
		}
		return res;
	}
	
}
