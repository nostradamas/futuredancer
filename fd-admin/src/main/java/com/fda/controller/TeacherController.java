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
import com.fda.controller.req.EditTeacherDetailParam;
import com.fda.controller.req.GetBaseDetailParam;
import com.fda.controller.res.BaseResult;
import com.fda.controller.res.DataTablesResult;
import com.fda.controller.res.ListResult;
import com.fda.model.HomeBean;
import com.fda.model.TeacherBean;
import com.fda.service.HomeService;
import com.fda.service.TeacherService;
import com.fda.service.exception.ServiceException;
import com.fda.util.NumUtil;
import com.fda.util.QiniuUtil;
import com.fda.util.StringUtil;

/**
 * 教师controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherServiceImpl;
	

	@Autowired
	HomeService homeServiceImpl;
	
	/**
	 * 教师管理
	 * @return
	 */
	@RequestMapping("/toTeacherMain")
	public ModelAndView toTeacherMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
	    String homeId = StringUtil.toString(request.getParameter("homeId"), null);
        mv.addObject("homeId", homeId);
		
		mv.setViewName("/teach/teacherMain");
		return mv;
	}
	
	/**
	 * 获取教师列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getTeacherLists")
    @ResponseBody
    public DataTablesResult<TeacherBean> getTeacherLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<TeacherBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        String homeId = StringUtil.toString(request.getParameter("homeId"), null);
        int type =  NumUtil.toInt(request.getParameter("type"), 0);
        ListResult<TeacherBean> res = teacherServiceImpl.getTeacherLists(start, length, homeId, type);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	
	@RequestMapping("/toTeacherDetail")
	public ModelAndView toTeacherDetail(HttpServletRequest request, HttpServletResponse response,
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

		
		TeacherBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new TeacherBean();
		} else {
			bean = teacherServiceImpl.getTeacherById(param.getId());
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("teach/teacherDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/teacherSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditTeacherDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			TeacherBean bean = new TeacherBean();
			bean.setTid(param.getTid());
			bean.setBrief(param.getBrief());
			bean.setDetail(param.getDetail());
			bean.setHomeId(param.getHomeId());
			bean.setIcon(param.getIcon());
			bean.setImg(param.getImg());
			bean.setName(param.getName());
			bean.setSort(param.getSort());
			bean.setType(param.getType());
			boolean flag = teacherServiceImpl.saveTeacher(bean);
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

	@RequestMapping("/teacherDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = teacherServiceImpl.deleteTeacherById(id);
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
		String tid = StringUtil.toString(request.getParameter("tid"), null);
		int atHome = NumUtil.toInt(request.getParameter("atHome"), 0 );
		try {
			TeacherBean bean = new TeacherBean();
			bean.setTid(tid);
			bean.setAtHome(atHome);
			boolean flag = teacherServiceImpl.saveTeacher(bean);
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
