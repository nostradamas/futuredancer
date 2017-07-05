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
import com.fdm.controller.req.EditClassIntroduceDetailParam;
import com.fdm.controller.req.GetBaseDetailParam;
import com.fdm.controller.res.BaseResult;
import com.fdm.controller.res.DataTablesResult;
import com.fdm.controller.res.ListResult;
import com.fdm.model.ClassIntroduceBean;
import com.fdm.service.ClassIntroduceService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.StringUtil;

/**
 * 少儿舞蹈课程介绍controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/classIntroduce")
public class ClassIntroduceController {

	@Autowired
	ClassIntroduceService classIntroduceServiceImpl;
	
	/**
	 * 少儿课程管理
	 * @return
	 */
	@RequestMapping("/toClassIntroduceMain")
	public ModelAndView toClassIntroduceMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/introduce/classIntroduceMain");
		return mv;
	}
	
	/**
	 * 获取少儿课程列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getClassIntroduceLists")
    @ResponseBody
    public DataTablesResult<ClassIntroduceBean> getClassIntroduceLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<ClassIntroduceBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        ListResult<ClassIntroduceBean> res = classIntroduceServiceImpl.getClassIntroduceLists(start, length);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	
	@RequestMapping("/toClassIntroduceDetail")
	public ModelAndView toClassIntroduceDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		ClassIntroduceBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new ClassIntroduceBean();
		} else {
			bean = classIntroduceServiceImpl.getClassIntroduceById(param.getId());
		}
		mv.setViewName("introduce/classIntroduceDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/classIntroduceSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditClassIntroduceDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			ClassIntroduceBean bean = new ClassIntroduceBean();
			bean.setCid(param.getCid());
			bean.setName(param.getName());
			bean.setSort(param.getSort());
			bean.setTabId(param.getTabId());
			boolean flag = classIntroduceServiceImpl.saveClassIntroduce(bean);
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

	@RequestMapping("/classIntroduceDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = classIntroduceServiceImpl.deleteClassIntroduceById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}
	
}
