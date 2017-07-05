package com.fdm.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdm.controller.res.ListResult;
import com.fdm.controller.res.ObjectResult;
import com.fdm.controller.resmodel.ResNewsBean;
import com.fdm.controller.resmodel.ResNewsListBean;
import com.fdm.model.NewsBean;
import com.fdm.model.NewsCategoryBean;
import com.fdm.service.NewsService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.NumUtil;
import com.fdm.util.StringUtil;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	NewsService newsServiceImpl;

	@RequestMapping("/getList/{cid}")
	@ResponseBody
	public ListResult<ResNewsListBean> getLists(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String cid) {
		ListResult<ResNewsListBean> result = new ListResult<ResNewsListBean>();
		try {
			String sch = StringUtil.toString(request.getParameter("sch"), null);//
			int page = NumUtil.toInt(request.getParameter("page"), 1);
			int pageSize = NumUtil.toInt(request.getParameter("pageSize"), 10);
			result = newsServiceImpl.getNewsList(page, pageSize, cid, sch);
		} catch (ServiceException e) {
			result.setFlag(false);
			result.setMsg(e.getServiceMsg());
		}
		return result;
	}

	@RequestMapping("/getCategoryList")
	@ResponseBody
	public ListResult<NewsCategoryBean> getCategoryLists(HttpServletRequest request, HttpServletResponse response) {
		ListResult<NewsCategoryBean> result = new ListResult<NewsCategoryBean>();
		try {
			String sch = StringUtil.toString(request.getParameter("sch"), null);//
			List<NewsCategoryBean> res = newsServiceImpl.getNewsCategory(sch);
			result.setData(res != null ? res : null);
			result.setFlag(res != null);
			result.setTotalSize(res != null ? res.size() : 0);
		} catch (ServiceException e) {
			result.setFlag(false);
			result.setMsg(e.getServiceMsg());
		}
		return result;
	}

	@RequestMapping("/getDetail/{nid}")
	@ResponseBody
	public ObjectResult<ResNewsBean> getDetail(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String nid) {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ObjectResult<ResNewsBean> result = new ObjectResult<>();
		try {
			NewsBean newsBean = newsServiceImpl.getNewsById(nid);
			ResNewsBean res = new ResNewsBean();
			if (newsBean != null) {
				Timestamp date = newsBean.getCreateTime();
				if (date == null) {
					res.setCreateTime(sdf.format(new Date()));
				} else {
					res.setCreateTime(sdf.format(date));
				}
				res.setBrief(newsBean.getBrief());
				res.setContent(newsBean.getContent());
				res.setImg(newsBean.getImg());
				res.setTitle(newsBean.getTitle());
				res.setNid(newsBean.getNid());
			}
			result.setData(res);
		} catch (ServiceException e) {
			result.setFlag(false);
			result.setMsg(e.getServiceMsg());
		}
		return result;
	}

}
