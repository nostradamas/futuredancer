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

import com.fda.constants.RescodeConstants;
import com.fda.controller.req.BaseDataTablesReq;
import com.fda.controller.req.EditNewsCategoryParam;
import com.fda.controller.req.EditNewsDetailParam;
import com.fda.controller.req.GetBaseDetailParam;
import com.fda.controller.res.BaseResult;
import com.fda.controller.res.DataTablesResult;
import com.fda.controller.res.ListResult;
import com.fda.model.NewsBean;
import com.fda.model.NewsCategoryBean;
import com.fda.service.NewsService;
import com.fda.service.exception.ServiceException;
import com.fda.util.NumUtil;
import com.fda.util.QiniuUtil;
import com.fda.util.StringUtil;


@Controller
@RequestMapping("/admin/news")
public class NewsController {

	@Autowired
	NewsService newsServiceImpl;
	
	/**
	 * 新闻管理
	 * @return
	 */
	@RequestMapping("/toNewsMain")
	public ModelAndView toNewsMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/news/newsMain");
		return mv;
	}
	
	@RequestMapping("/getLists")
    @ResponseBody
    public DataTablesResult<NewsBean> getLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<NewsBean> result = new DataTablesResult<>();

        Integer start = param.getStart(); 
        Integer length = param.getLength();
        String cid =  StringUtil.toString(request.getParameter("cid"), null);// 按时间排序
        String sch_name = request.getParameter("sch_content");
        ListResult<NewsBean> res = newsServiceImpl.getNewsList(start, length, cid, sch_name);

        result.setData(res.getData());
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.getTotalSize());
        result.setRecordsFiltered(res.getTotalSize());

        return result;
    }
	
	@RequestMapping("/toObjectDetail")
	public ModelAndView toObjectDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		NewsBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new NewsBean();
		} else {
			bean = newsServiceImpl.getNewsById(param.getId());
		}
		List<NewsCategoryBean> cates = newsServiceImpl.getNewsCategory(null);
		if (cates != null) {
			mv.addObject("cates", cates);
		}
		mv.addObject("uptoken", QiniuUtil.getInstance().getUpToken());
		mv.setViewName("news/newsDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/objectSave")
	@ResponseBody
	public BaseResult objectSave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditNewsDetailParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			NewsBean bean = new NewsBean();
			bean.setNid(param.getNid());
			bean.setTitle(param.getTitle());
			bean.setContent(param.getContent());
			bean.setBrief(param.getBrief());
			bean.setImg(param.getImg());
			bean.setLinkUrl(param.getLinkUrl());
			bean.setCid(param.getCid());
			bean.setSort(param.getSort());
			bean.setCreateCode(param.getCreateCode());
			boolean flag = newsServiceImpl.save(bean);
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
	
	@RequestMapping("/updateTop")
	@ResponseBody
	public BaseResult updateTop(HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		String nid = StringUtil.toString(request.getParameter("nid"), null);
		int isTop = NumUtil.toInt(request.getParameter("isTop"), 0 );
		try {
			NewsBean bean = new NewsBean();
			bean.setNid(nid);
			bean.setIsTop(isTop);
			boolean flag = newsServiceImpl.save(bean);
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
	
	@RequestMapping("/objectDelete")
	@ResponseBody
	public BaseResult objectDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = newsServiceImpl.deleteById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}

	
	
	/**
	 * 新闻分类
	 * @return
	 */
	@RequestMapping("/toNewCategoryMain")
	public ModelAndView toNewCategoryMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/news/newsCategory");
		return mv;
		
	}
	
	@RequestMapping("/getCateLists")
    @ResponseBody
    public DataTablesResult<NewsCategoryBean> getCateLists(HttpServletRequest request, HttpServletResponse response,
                                                   @Validated BaseDataTablesReq param, BindingResult error) {
        DataTablesResult<NewsCategoryBean> result = new DataTablesResult<>();

        String sch_name = request.getParameter("sch_content");
        List<NewsCategoryBean> res = newsServiceImpl.getNewsCategory(sch_name);

        result.setData(res);
        result.setDraw(param.getDraw()); 
        result.setRecordsTotal(res.size());
        result.setRecordsFiltered(res.size());

        return result;
    }
	
	
	@RequestMapping("/toCategoryDetail")
	public ModelAndView toCategoryDetail(HttpServletRequest request, HttpServletResponse response,
			@Validated GetBaseDetailParam param, BindingResult error) {
		ModelAndView mv = new ModelAndView();
		NewsCategoryBean bean;

		if (StringUtil.checkEmpty(param.getId())) {
			bean = new NewsCategoryBean();
		} else {
			bean = newsServiceImpl.getNewsCategoryById(param.getId());
		}
		mv.setViewName("news/categoryDetail");
		mv.addObject("bean", bean);

		return mv;
	}

	@RequestMapping("/categorySave")
	@ResponseBody
	public BaseResult categorySave(HttpServletRequest request, HttpServletResponse response,
			@Validated EditNewsCategoryParam param, BindingResult error) {
		BaseResult result = new BaseResult();
		if (error.hasErrors()) {
			result.setRescode(BaseResult.param.getCode());
			result.setMsg(error.getFieldError().getDefaultMessage());
			return result;
		}
		try {
			NewsCategoryBean bean = new NewsCategoryBean();
			bean.setName(param.getName());
			bean.setCid(param.getCid());
			bean.setSort(param.getSort());
			boolean flag = newsServiceImpl.saveCategory(bean);
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

	@RequestMapping("/categoryDelete")
	@ResponseBody
	public BaseResult categoryDelete(HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		String id = request.getParameter("id");
		try {
			boolean flag = newsServiceImpl.deleteCategoryById(id);
			res.setFlag(flag);
		} catch (ServiceException e) {
			res.setRescode(e.getServiceCode());
			res.setMsg(e.getServiceMsg());
		}
		return res;
	}
}
