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
import com.fdm.controller.req.EditContentDetailParam;
import com.fdm.controller.req.EditHomeDetailParam;
import com.fdm.controller.req.GetBaseDetailParam;
import com.fdm.controller.res.BaseResult;
import com.fdm.controller.res.DataTablesResult;
import com.fdm.controller.res.ListResult;
import com.fdm.model.HomeBean;
import com.fdm.model.IndexContentBean;
import com.fdm.service.HomeService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.QiniuUtil;
import com.fdm.util.StringUtil;

/**
 * 主页controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/home")
public class HomeController {

	@Autowired
	HomeService homeServiceImpl;
	
	/**
	 * 主页管理
	 * @return
	 */
	@RequestMapping("/toHomeMain")
	public ModelAndView toHomeMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/homeMain");
		return mv;
	}
	
	/**
	 * 获取主页列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getHomeLists")
    @ResponseBody
    public DataTablesResult<HomeBean> getHomeLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<HomeBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        ListResult<HomeBean> res = homeServiceImpl.getHomeLists(start, length);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());
        return result;
    }
	
	
	@RequestMapping("/toHomeDetail")
	public ModelAndView toHomeDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		HomeBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new HomeBean();
		} else {
			bean = homeServiceImpl.getHomeById(param.getId());
		}
		mv.setViewName("home/homeDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/homeSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditHomeDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			HomeBean bean = new HomeBean();
			bean.setHid(param.getHid());
			bean.setName(param.getName());
			bean.setSort(param.getSort());
			boolean flag = homeServiceImpl.saveHome(bean);
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

	@RequestMapping("/homeDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = homeServiceImpl.deleteHomeById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}
	
	
	/**
	 * 主页内容管理
	 * @return
	 */
	@RequestMapping("/toContentMain")
	public ModelAndView toContentMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
        String homeId = StringUtil.toString(request.getParameter("homeId"), null);
        mv.addObject("homeId", homeId);
		mv.setViewName("/home/contentMain");
		return mv;
	}
	
	/**
	 * 获取主页内容列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getContentLists")
    @ResponseBody
    public DataTablesResult<IndexContentBean> getContentLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<IndexContentBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        String homeId = StringUtil.toString(request.getParameter("homeId"), null);
        ListResult<IndexContentBean> res = homeServiceImpl.getContentLists(start, length, homeId);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());
        return result;
    }

	@RequestMapping("/toContentDetail")
	public ModelAndView toContentDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		IndexContentBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new IndexContentBean();
		} else {
			bean = homeServiceImpl.getContentById(param.getId());
		}
		mv.setViewName("home/contentDetail");
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/contentSave")
	@ResponseBody
	public BaseResult contentSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditContentDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			IndexContentBean bean = new IndexContentBean();
			bean.setMid(param.getMid());
			bean.setBackground(param.getBackground());
			bean.setBrief(param.getBrief());
			bean.setHomeId(param.getHomeId());
			bean.setIcon(param.getIcon());
			bean.setName(param.getName());
			bean.setSort(param.getSort());
			bean.setSubImg(param.getSubImg());
			bean.setSubName(param.getSubName());
			boolean flag = homeServiceImpl.saveContent(bean);
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
	
	@RequestMapping("/contentDelete")
	@ResponseBody
	public BaseResult contentDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = homeServiceImpl.deleteContentById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}
	
}
