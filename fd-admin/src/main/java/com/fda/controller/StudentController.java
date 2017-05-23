package com.fda.controller;

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

import com.alibaba.fastjson.JSON;
import com.fda.constants.RescodeConstants;
import com.fda.controller.req.BaseDataTablesReq;
import com.fda.controller.req.EditStudentDetailParam;
import com.fda.controller.req.GetBaseDetailParam;
import com.fda.controller.req.SaveHomeIdParam;
import com.fda.controller.res.BaseResult;
import com.fda.controller.res.DataTablesResult;
import com.fda.controller.res.ListResult;
import com.fda.model.HomeBean;
import com.fda.model.StudentBean;
import com.fda.model.StudentHomeBean;
import com.fda.service.HomeService;
import com.fda.service.StudentService;
import com.fda.service.exception.ServiceException;
import com.fda.util.NumUtil;
import com.fda.util.QiniuUtil;
import com.fda.util.StringUtil;

/**
 * 教师controller层
 * 
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/student")
public class StudentController {

	@Autowired
	StudentService studentServiceImpl;

	@Autowired
	HomeService homeServiceImpl;

	/**
	 * 教师管理
	 * 
	 * @return
	 */
	@RequestMapping("/toStudentMain")
	public ModelAndView toStudentMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String homeId = StringUtil.toString(request.getParameter("homeId"), null);
		mv.addObject("homeId", homeId);
		mv.setViewName("/teach/studentMain");
		return mv;
	}

	/**
	 * 获取教师列表
	 * 
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getStudentLists")
	@ResponseBody
	public DataTablesResult<StudentBean> getStudentLists(HttpServletRequest request, HttpServletResponse response,
			@Validated BaseDataTablesReq param, BindingResult error) {
		DataTablesResult<StudentBean> result = new DataTablesResult<>();

		Integer start = param.getStart();
		Integer length = param.getLength();
		String homeId = StringUtil.toString(request.getParameter("homeId"), null);
		ListResult<StudentBean> res = studentServiceImpl.getStudents(start, length, homeId);
		result.setData(res.getData());
		result.setDraw(param.getDraw());
		result.setRecordsTotal(res.getTotalSize());
		result.setRecordsFiltered(res.getTotalSize());

		return result;
	}

	@RequestMapping("/toStudentDetail")
	public ModelAndView toStudentDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();

		String homeId = StringUtil.toString(request.getParameter("homeId"), null);
		String homeName = "";
		HomeBean homeBean = homeServiceImpl.getHomeById(homeId);
		if (homeBean != null) {
			homeName = homeBean.getName();
		}
		mv.addObject("homeId", homeId);
		mv.addObject("homeName", homeName);

		StudentBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new StudentBean();
		} else {
			bean = studentServiceImpl.getStudentById(param.getId());
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("teach/studentDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/studentSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditStudentDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			StudentBean bean = new StudentBean();
			bean.setBrief(param.getBrief());
			bean.setSid(param.getSid());
			bean.setDetail(param.getDetail());
			bean.setImg(param.getImg());
			bean.setName(param.getName());
			bean.setSort(param.getSort());
			boolean flag = studentServiceImpl.saveStudent(bean);
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

	@RequestMapping("/studentDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = studentServiceImpl.deleteStudentById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}

	@RequestMapping("/updateShow")
	@ResponseBody
	public BaseResult updateShow(HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		String sid = StringUtil.toString(request.getParameter("sid"), null);
		int atHome = NumUtil.toInt(request.getParameter("atHome"), 0);
		try {
			StudentBean bean = new StudentBean();
			bean.setSid(sid);
			bean.setAtHome(atHome);
			boolean flag = studentServiceImpl.saveStudent(bean);
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

	
	@RequestMapping("/toChooseHome")
	public ModelAndView toChooseHome(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		String studentId = param.getId();
		mv.addObject("sid", studentId);
		
		List<StudentHomeBean> shomes = studentServiceImpl.selectHomesByStudentId(studentId);
		int i = 0;
		String[] homeIds = new String[shomes.size()];
		if(shomes != null && shomes.size() > 0){
			for(StudentHomeBean h : shomes) {
				homeIds[i] = h.getHomeId();
				i++;
			}
		} 
		mv.addObject("homeIds", JSON.toJSONString(homeIds));
		mv.setViewName("teach/studentHome");

		return mv;
	}

	@RequestMapping("/saveHomeId")
	@ResponseBody
	public BaseResult saveHomeId(HttpServletRequest request, HttpServletResponse response,
			@Validated SaveHomeIdParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			String studentId = param.getId();
			String[] homeIds = param.getHomeIds();
			boolean flag = studentServiceImpl.saveHomeId(homeIds, studentId);
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
