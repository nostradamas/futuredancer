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
import com.fdm.controller.req.EditCoursePackDetailParam;
import com.fdm.controller.req.GetBaseDetailParam;
import com.fdm.controller.res.BaseResult;
import com.fdm.controller.res.DataTablesResult;
import com.fdm.controller.res.ListResult;
import com.fdm.model.CoursePackBean;
import com.fdm.model.HomeBean;
import com.fdm.service.CoursePackService;
import com.fdm.service.HomeService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.QiniuUtil;
import com.fdm.util.StringUtil;

/**
 * 课程包controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/coursePack")
public class CoursePackController {

	@Autowired
	CoursePackService coursePackServiceImpl;

	@Autowired
	HomeService homeServiceImpl;
	/**
	 * 课程包管理
	 * @return
	 */
	@RequestMapping("/toCoursePackMain")
	public ModelAndView toCoursePackMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
	    String homeId = StringUtil.toString(request.getParameter("homeId"), null);
	    mv.addObject("homeId", homeId);
		
		mv.setViewName("/coursePack/coursePackMain");
		return mv;
	}
	
	/**
	 * 获取课程包列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getCoursePackLists")
    @ResponseBody
    public DataTablesResult<CoursePackBean> getCoursePackLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<CoursePackBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        String homeId = StringUtil.toString(request.getParameter("homeId"), null);
        ListResult<CoursePackBean> res = coursePackServiceImpl.getCoursePackLists(start, length, homeId);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	
	@RequestMapping("/toCoursePackDetail")
	public ModelAndView toCoursePackDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();

	    String homeId = StringUtil.toString(request.getParameter("homeId"), null);
		String homeName = "";
		HomeBean homeBean = homeServiceImpl.getHomeById(homeId);
		if(homeBean!=null){
			homeName = homeBean.getName();
        }
	    mv.addObject("homeId", homeId);
	    mv.addObject("homeName", homeName);

		CoursePackBean bean;
		if (StringUtil.checkEmpty(param.getId())) {
			bean = new CoursePackBean();
		} else {
			bean = coursePackServiceImpl.getCoursePackById(param.getId());
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("coursePack/coursePackDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/coursePackSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditCoursePackDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			CoursePackBean bean = new CoursePackBean();
			bean.setBrief(param.getBrief());
			bean.setCid(param.getCid());
			bean.setHomeId(param.getHomeId());
			bean.setImg(param.getImg());
			bean.setName(param.getName());
			bean.setSort(param.getSort());
			bean.setTeacher(param.getTeacher());
			boolean flag = coursePackServiceImpl.saveCoursePack(bean);
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

	@RequestMapping("/coursePackDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = coursePackServiceImpl.deleteCoursePackById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}
	

}
