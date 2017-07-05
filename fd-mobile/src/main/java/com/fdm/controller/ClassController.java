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
import com.fdm.controller.req.EditClassDetailParam;
import com.fdm.controller.req.GetBaseDetailParam;
import com.fdm.controller.res.BaseResult;
import com.fdm.controller.res.DataTablesResult;
import com.fdm.controller.res.ListResult;
import com.fdm.model.ClassBean;
import com.fdm.service.ClassService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.QiniuUtil;
import com.fdm.util.StringUtil;

/**
 * 视频课程controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/class")
public class ClassController {

	@Autowired
	ClassService ClassServiceImpl;
	
	/**
	 * 视频课程管理
	 * @return
	 */
	@RequestMapping("/toClassMain")
	public ModelAndView toClassMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/teach/classMain");
		return mv;
	}
	
	/**
	 * 获取视频课程列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getClassLists")
    @ResponseBody
    public DataTablesResult<ClassBean> getClassLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<ClassBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        ListResult<ClassBean> res = ClassServiceImpl.getClasses(start, length);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	
	@RequestMapping("/toClassDetail")
	public ModelAndView toClassDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		ClassBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new ClassBean();
		} else {
			bean = ClassServiceImpl.getClassById(param.getId());
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("teach/classDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/classSave")
	@ResponseBody
	public BaseResult ClassSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditClassDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			ClassBean bean = new ClassBean();
			bean.setCid(param.getCid());
			bean.setBrief(param.getBrief());
			bean.setImg(param.getImg());
			bean.setName(param.getName());
			bean.setSort(param.getSort());
			bean.setVideoUrl(param.getVideoUrl());
			bean.setViewNum(0);
			boolean flag = ClassServiceImpl.saveClass(bean);
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

	@RequestMapping("/classDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = ClassServiceImpl.deleteClassById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}


}
