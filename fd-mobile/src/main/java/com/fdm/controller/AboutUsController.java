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
import com.fdm.controller.req.EditAboutusDetailParam;
import com.fdm.controller.req.EditEnvironmentDetailParam;
import com.fdm.controller.req.EditPageContentDetailParam;
import com.fdm.controller.req.GetBaseDetailParam;
import com.fdm.controller.res.BaseResult;
import com.fdm.controller.res.DataTablesResult;
import com.fdm.controller.res.ListResult;
import com.fdm.model.AboutusBean;
import com.fdm.model.EnvironmentBean;
import com.fdm.model.PageContentBean;
import com.fdm.service.AboutusService;
import com.fdm.service.PageContentService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.NumUtil;
import com.fdm.util.QiniuUtil;
import com.fdm.util.StringUtil;

/**
 * 关于我们controller层
 * @author nostr
 *
 */

@Controller
@RequestMapping("/admin/aboutus")
public class AboutUsController {

	@Autowired
	AboutusService aboutusServiceImpl;
	

	@Autowired
	PageContentService pageContentServiceImpl;
	
	/**
	 * 关于我们内容管理
	 * @return
	 */
	@RequestMapping("/toAboutusMain")
	public ModelAndView toAboutusMain() {
		ModelAndView mv = new ModelAndView();
		AboutusBean bean  = aboutusServiceImpl.getAboutus();
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("aboutus/aboutusDetail");
		mv.addObject("bean", bean);
		return mv;
	}
	
	@RequestMapping("/aboutusSave")
	@ResponseBody
	public BaseResult aboutusSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditAboutusDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			AboutusBean bean = new AboutusBean();
			bean.setAid(param.getAid());
			bean.setAboutus(param.getAboutus());
			bean.setEnlighten(param.getEnlighten());
			bean.setPopularize(param.getPopularize());
			bean.setSpecialty(param.getSpecialty());
			bean.setModeImg(param.getModeImg());
			bean.setLogo(param.getLogo());
			boolean flag = aboutusServiceImpl.saveAboutus(bean);
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

	
	/**
	 * 证书环境管理
	 * @return
	 */
	@RequestMapping("/toEnvironmentMain")
	public ModelAndView toEnvironmentMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aboutus/environmentMain");
		return mv;
	}
	
	/**
	 * 获取证书环境列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getEnvironmentLists")
    @ResponseBody
    public DataTablesResult<EnvironmentBean> getEnvironmentLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<EnvironmentBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        int type =  NumUtil.toInt(request.getParameter("type"), 0);
        ListResult<EnvironmentBean> res = aboutusServiceImpl.getEnvironmentLists(start, length, type);
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	
	@RequestMapping("/toEnvironmentDetail")
	public ModelAndView toEnvironmentDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		EnvironmentBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new EnvironmentBean();
		} else {
			bean = aboutusServiceImpl.getEnvironmentById(param.getId());
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("aboutus/environmentDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/environmentSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditEnvironmentDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			EnvironmentBean bean = new EnvironmentBean();
			bean.setEid(param.getEid());
			bean.setName(param.getName());
			bean.setUrl(param.getUrl());
			bean.setType(NumUtil.toInt(param.getType(),1));
			bean.setIsDel(NumUtil.toInt(param.getIsDel(),0));
			bean.setSort(param.getSort());
			boolean flag = aboutusServiceImpl.saveEnvironment(bean);
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

	@RequestMapping("/environmentDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = aboutusServiceImpl.deleteEnvironmentById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}

	
	/**
	 * 公司文化管理
	 * @return
	 */
	@RequestMapping("/toCultureMain")
	public ModelAndView toCultureMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aboutus/cultureMain");
		return mv;
	}
	
	/**
	 * 获取公司文化列表
	 * @param request
	 * @param response
	 * @param param
	 * @param error
	 * @return
	 */
	@RequestMapping("/getCultureLists")
    @ResponseBody
    public DataTablesResult<PageContentBean> getCultureLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<PageContentBean> result = new DataTablesResult<>();
    	AboutusBean bean  = aboutusServiceImpl.getAboutus();
        Integer start = param.getStart(); 
        Integer length = param.getLength();
        ListResult<PageContentBean> res = pageContentServiceImpl.getLists(start, length, bean.getAid());
        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	
	@RequestMapping("/toCultureDetail")
	public ModelAndView toCultureDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		PageContentBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new PageContentBean();
		} else {
			bean = pageContentServiceImpl.getContentById(param.getId());
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("aboutus/cultureDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/cultureSave")
	@ResponseBody
	public BaseResult cultureSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditPageContentDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			AboutusBean abean  = aboutusServiceImpl.getAboutus();
			PageContentBean bean = new PageContentBean();
			bean.setPid(param.getPid());
			bean.setTitle(param.getTitle());
			bean.setSubTitle(param.getSubTitle());
			bean.setContent(param.getContent());
			bean.setPic(param.getPic());
			bean.setBackground(param.getBackground());
			bean.setSort(param.getSort());
			bean.setContentId(param.getContentId());
			bean.setTargetId(abean.getAid());
			bean.setType(3);
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

	@RequestMapping("/cultureDelete")
	@ResponseBody
	public BaseResult cultureDelete(HttpServletRequest request, HttpServletResponse response) {
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
