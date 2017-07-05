package com.fdm.controller;

import java.util.List;

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
import com.fdm.controller.req.EditBannerCodeDetailParam;
import com.fdm.controller.req.EditBannerDetailParam;
import com.fdm.controller.req.GetBaseDetailParam;
import com.fdm.controller.res.BaseResult;
import com.fdm.controller.res.DataTablesResult;
import com.fdm.controller.res.ListResult;
import com.fdm.model.BannerBean;
import com.fdm.model.BannerCodeBean;
import com.fdm.service.BannerService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.NumUtil;
import com.fdm.util.QiniuUtil;
import com.fdm.util.StringUtil;

/**
 * banner controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/banner")
public class BannerController {

	@Autowired
	BannerService bannerServiceImpl;
	
	/**
	 * banner管理
	 * @return
	 */
	@RequestMapping("/toBannerMain")
	public ModelAndView toBannerMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/banner/bannerMain");
		return mv;
	}
	
	/**
	 * bannerCode管理
	 * @return
	 */
	@RequestMapping("/toBannerCodeMain")
	public ModelAndView toBannerCodeMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/banner/bannerCodeMain");
		return mv;
	}
	
	/**
	 * 获取Banner列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getLists")
    @ResponseBody
    public DataTablesResult<BannerBean> getLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<BannerBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        int code =  NumUtil.toInt(request.getParameter("code"), 0);
        int type =  NumUtil.toInt(request.getParameter("type"), 0);
        ListResult<BannerBean> res = bannerServiceImpl.getLists(start, length, code, type);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	
	@RequestMapping("/toBannerDetail")
	public ModelAndView toBannerDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		BannerBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new BannerBean();
		} else {
			bean = bannerServiceImpl.getBannerById(param.getId());
		}
		List<BannerCodeBean> codes = bannerServiceImpl.getCodeLists();
		if(codes != null && codes.size() > 0) {
			mv.addObject("codes", codes);
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("banner/bannerDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/bannerSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditBannerDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			BannerBean bean = new BannerBean();
			bean.setBannerCode(NumUtil.toInt(param.getBannerCode(),0));
			bean.setBid(param.getBid());
			bean.setImgUrl(param.getImgUrl());
			bean.setLinkUrl(param.getLinkUrl());
			bean.setSort(param.getSort());
			bean.setTitle(param.getTitle());
			bean.setType(NumUtil.toInt(param.getType(),0));
			boolean flag = bannerServiceImpl.saveBanner(bean);
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

	@RequestMapping("/bannerDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = bannerServiceImpl.deleteBannerById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}

	
	
	/**
	 * 获取Banner列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getCodeLists")
    @ResponseBody
    public DataTablesResult<BannerCodeBean> getCodeLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<BannerCodeBean> result = new DataTablesResult<>();
        List<BannerCodeBean> res = bannerServiceImpl.getCodeLists();
        result.setData(res);
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.size());
        result.setRecordsFiltered(res.size());
        return result;
    }
	

	@RequestMapping("/toBannerCodeDetail")
	public ModelAndView toBannerCodeDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		BannerCodeBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new BannerCodeBean();
		} else {
			bean = bannerServiceImpl.getBannerCodeById(param.getId());
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("banner/bannerCodeDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/bannerCodeSave")
	@ResponseBody
	public BaseResult bannerCodeSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditBannerCodeDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			BannerCodeBean bean = new BannerCodeBean();
			bean.setBannerCode(NumUtil.toInt(param.getBannerCode(), 0));
			bean.setCid(param.getCid());
			bean.setName(param.getName());
			boolean flag = bannerServiceImpl.saveBannerCode(bean);
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

	@RequestMapping("/bannerCodeDelete")
	@ResponseBody
	public BaseResult bannerCodeDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = bannerServiceImpl.deleteBannerCodeById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}
	
}
