package com.fdw.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.controller.res.ListResult;
import com.fdw.controller.res.ResNewsList;
import com.fdw.model.NewsBean;
import com.fdw.model.NewsCategoryBean;
import com.fdw.persist.dao.NewsDao;
import com.fdw.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsDao newsImpl;

	@Override
	public ListResult<ResNewsList> getNewsList(int page, int pageSize, String cid) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ListResult<ResNewsList> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		int start = (page - 1) * pageSize;
		params.put("start", start);
		params.put("pageSize", pageSize);
		params.put("cid", cid);
		int totalSize = newsImpl.selectTotal(params);
		List<NewsBean> beans = newsImpl.selectNewsInPage(params);
		List<ResNewsList> res = new ArrayList<>();
		if(beans != null && beans.size() > 0){
			for(NewsBean n : beans) {
				ResNewsList re = new ResNewsList();
				re.setNid(n.getNid());
				re.setTitle(n.getTitle());
				re.setBrief(n.getBrief());
				re.setCreateTime(sdf.format(n.getCreateTime()));
				re.setImg(n.getImg());
				re.setCreateCode(n.getCreateCode());
				res.add(re);
			}
		}
		
		result.setPage(page);
		result.setData(res);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public List<NewsCategoryBean> getNewsCategory() {
		return newsImpl.selectNewsCategory();
	}

	@Override
	public NewsBean getNewsById(String nid) {
		return newsImpl.selectNewsById(nid);
	}

	@Override
	public NewsBean getNewsByCode(String newscode) {
		return newsImpl.selectNewsByCode(newscode);
	}

}
