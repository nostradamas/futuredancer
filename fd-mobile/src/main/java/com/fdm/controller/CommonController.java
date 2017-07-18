package com.fdm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdm.constants.RescodeConstants;
import com.fdm.controller.req.SubmitQuestionParam;
import com.fdm.controller.res.BaseResult;
import com.fdm.model.QuestionBean;
import com.fdm.service.StudentService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.NumUtil;

/**
 * 功能controller层
 * 
 * @author nostr
 *
 */

@Controller
@RequestMapping("/common")
public class CommonController {

	@Autowired
	StudentService studentServiceImpl;

	@RequestMapping("/submitQuestion")
	@ResponseBody
	public BaseResult submitQuestion(HttpServletRequest request, HttpServletResponse response,
			@Validated SubmitQuestionParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			QuestionBean bean = new QuestionBean();
			bean.setName(param.getName());
			bean.setQuestion(param.getQuestion());
			bean.setTelephone(param.getTelephone());
			bean.setType(NumUtil.toInt(param.getType(), 1));
			boolean flag = studentServiceImpl.saveQuestion(bean);
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
}
