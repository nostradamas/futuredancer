package com.fdm.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.controller.res.ListResult;
import com.fdm.controller.resmodel.ResNewsListBean;
import com.fdm.model.NewsBean;
import com.fdm.model.NewsCategoryBean;
import com.fdm.persist.dao.NewsDao;
import com.fdm.service.NewsService;
import com.fdm.util.StringUtil;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsDao newsImpl;

	@Override
	public ListResult<ResNewsListBean> getNewsList(int start, int pageSize, String cid, String sch) {
		ListResult<ResNewsListBean> result = new ListResult<>();
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", pageSize);
		if (!StringUtil.checkEmpty(cid)) {
			params.put("cid", cid);
		}
		params.put("content", sch);
		int totalSize = newsImpl.selectTotal(params);
		List<NewsBean> beans = newsImpl.selectNewsInPage(params);
		List<ResNewsListBean> resData = new ArrayList<>();
		if(totalSize > 0 && beans != null){
			for(NewsBean b : beans){
				String createTime =  sdf.format(new Date());  
				ResNewsListBean re = new ResNewsListBean();
				re.setBrief(b.getBrief());
				if(b.getCreateTime() != null) {
					createTime = sdf.format(b.getCreateTime());
				}
				re.setCreateTime(createTime);
				re.setImg(b.getImg());
				re.setNid(b.getNid());
				re.setTitle(b.getTitle());
				resData.add(re);
			}
		}
		
		result.setData(resData);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public List<NewsCategoryBean> getNewsCategory(String schcontent) {
		return newsImpl.selectNewsCategory(schcontent);
	}

	@Override
	public NewsBean getNewsById(String nid) {
		return newsImpl.selectNewsById(nid);
	}

	@Override
	public ListResult<ResNewsListBean> getNewsListInType(int page, int pageSize, int type) {
		ListResult<ResNewsListBean> result = new ListResult<>();
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Map<String, Object> params = new HashMap<>();
		params.put("start", page);
		params.put("pageSize", pageSize);
		params.put("targetId", type);
		int totalSize = newsImpl.selectTotalInType(params);
		List<NewsBean> beans = newsImpl.selectNewsInPageInType(params);
		List<ResNewsListBean> resData = new ArrayList<>();
		if(totalSize > 0 && beans != null){
			for(NewsBean b : beans){
				String createTime =  sdf.format(new Date());  
				ResNewsListBean re = new ResNewsListBean();
				re.setBrief(b.getBrief());
				if(b.getCreateTime() != null) {
					createTime = sdf.format(b.getCreateTime());
				}
				re.setCreateTime(createTime);
				re.setImg(b.getImg());
				re.setNid(b.getNid());
				re.setTitle(b.getTitle());
				resData.add(re);
			}
		}
		
		result.setData(resData);
		result.setTotalSize(totalSize);
		return result;
	}
}
