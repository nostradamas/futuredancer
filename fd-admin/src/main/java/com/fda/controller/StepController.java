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
import com.fda.controller.req.BaseDataTablesReq;
import com.fda.controller.req.EditStepDetailParam;
import com.fda.controller.req.GetBaseDetailParam;
import com.fda.controller.res.BaseResult;
import com.fda.controller.res.DataTablesResult;
import com.fda.controller.res.ListResult;
import com.fda.model.StepBean;
import com.fda.service.StepService;
import com.fda.service.exception.ServiceException;
import com.fda.util.QiniuUtil;
import com.fda.util.StringUtil;

/**
 * 友情链接controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/step")
public class StepController {

	@Autowired
	StepService stepServiceImpl;
	
	/**
	 * 友情链接管理
	 * @return
	 */
	@RequestMapping("/toStepMain")
	public ModelAndView toStepMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String homeId = StringUtil.toString(request.getParameter("homeId"), null);
		mv.addObject("homeId", homeId);
		mv.setViewName("/step/stepMain");
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
	@RequestMapping("/getStepLists")
    @ResponseBody
    public DataTablesResult<StepBean> getStepLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<StepBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
		String homeId = StringUtil.toString(request.getParameter("homeId"), null);
        ListResult<StepBean> res = stepServiceImpl.getStepLists(start, length, homeId);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	
	@RequestMapping("/toStepDetail")
	public ModelAndView toStepDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		StepBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new StepBean();
		} else {
			bean = stepServiceImpl.getStepById(param.getId());
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("step/stepDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/stepSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditStepDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			StepBean bean = new StepBean();
			boolean flag = stepServiceImpl.saveStep(bean);
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

	@RequestMapping("/stepDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = stepServiceImpl.deleteStepById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setMsg(e.getServiceMsg());
			res.setRescode(e.getServiceCode());
		}
		return res;
	}
	
}
