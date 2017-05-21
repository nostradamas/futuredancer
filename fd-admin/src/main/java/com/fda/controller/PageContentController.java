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
import com.fda.controller.req.EditPageContentDetailParam;
import com.fda.controller.req.GetBaseDetailParam;
import com.fda.controller.res.BaseResult;
import com.fda.controller.res.DataTablesResult;
import com.fda.controller.res.ListResult;
import com.fda.model.PageContentBean;
import com.fda.service.PageContentService;
import com.fda.service.exception.ServiceException;
import com.fda.util.QiniuUtil;
import com.fda.util.StringUtil;

@Controller
@RequestMapping("/admin/pageContent")
public class PageContentController {
	
	
	@Autowired
	PageContentService pageContentServiceImpl;
	
	
	/**
	 * 包含课程介绍的主页管理
	 * @return
	 */
	@RequestMapping("/toPageHomeMain")
	public ModelAndView toPageHomeMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/content/homeMain");
		return mv;
	}
	
	/**
	 * 课程介绍管理
	 * @return
	 */
	@RequestMapping("/toPageContentMain")
	public ModelAndView toPageContentMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
	    String homeId = StringUtil.toString(request.getParameter("homeId"), null);
        mv.addObject("target", homeId);
		mv.setViewName("/content/pageContentMain");
		return mv;
	}
	
	/**
	 * 获取课程介绍列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getPageContentLists")
    @ResponseBody
    public DataTablesResult<PageContentBean> getPageContentLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<PageContentBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        String homeId = StringUtil.toString(request.getParameter("targetId"), null);
        ListResult<PageContentBean> res = pageContentServiceImpl.getLists(start, length, homeId);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	
	@RequestMapping("/toPageContentDetail")
	public ModelAndView toPageContentDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		PageContentBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new PageContentBean();
		} else {
			bean = pageContentServiceImpl.getContentById(param.getId());
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("content/pageContentDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/pageContentSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditPageContentDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			PageContentBean bean = new PageContentBean();
			bean.setPid(param.getPid());
			bean.setTitle(param.getTitle());
			bean.setSubTitle(param.getSubTitle());
			bean.setContent(param.getContent());
			bean.setPic(param.getPic());
			bean.setBackground(param.getBackground());
			bean.setSort(param.getSort());
			bean.setContentId(param.getContentId());
			bean.setTargetId(param.getTargetId());
			bean.setType(param.getType());
			boolean flag = pageContentServiceImpl.savePageContent(bean);
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

	@RequestMapping("/pageContentDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = pageContentServiceImpl.deletePageContentById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}


}
