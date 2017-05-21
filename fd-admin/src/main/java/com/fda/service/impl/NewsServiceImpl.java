package com.fda.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fda.constants.RescodeConstants;
import com.fda.controller.res.ListResult;
import com.fda.model.NewsBean;
import com.fda.model.NewsCategoryBean;
import com.fda.persist.dao.NewsDao;
import com.fda.service.NewsService;
import com.fda.service.exception.ServiceException;
import com.fda.util.AppTextUtil;
import com.fda.util.StringUtil;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsDao newsImpl;

	@Override
	public ListResult<NewsBean> getNewsList(int start, int pageSize, String cid, String sch) {
		ListResult<NewsBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", pageSize);
		if (!StringUtil.checkEmpty(cid)) {
			params.put("cid", cid);
		}
		params.put("content", sch);
		int totalSize = newsImpl.selectTotal(params);
		List<NewsBean> beans = newsImpl.selectNewsInPage(params);

		result.setData(beans);
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
	public boolean save(NewsBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getNid());
		if (isNew) {
			bean.setNid(AppTextUtil.getPrimaryKey());
			bean.setCreateCode(AppTextUtil.getNewsCode());
			flag = newsImpl.insert(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = newsImpl.update(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteById(String id) throws ServiceException {
		boolean flag = false;
		flag = newsImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}

	@Override
	public NewsCategoryBean getNewsCategoryById(String id) {
		return newsImpl.selectNewsCategoryById(id);
	}

	@Override
	public boolean saveCategory(NewsCategoryBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getCid());
		if (isNew) {
			bean.setCid(AppTextUtil.getPrimaryKey());
			flag = newsImpl.insertCategory(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = newsImpl.updateCategory(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteCategoryById(String id) throws ServiceException {
		boolean flag = false;
		flag = newsImpl.deleteCategoryById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}
}
