package com.fdm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.constants.RescodeConstants;
import com.fdm.controller.res.ListResult;
import com.fdm.model.BannerBean;
import com.fdm.model.BannerCodeBean;
import com.fdm.persist.dao.BannerDao;
import com.fdm.service.BannerService;
import com.fdm.service.exception.ServiceException;
import com.fdm.util.AppTextUtil;
import com.fdm.util.StringUtil;

@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	BannerDao bannerImpl;

	@Override
	public ListResult<BannerBean> getLists(int start, int pageSize, int code, int type) {
		ListResult<BannerBean> result = new ListResult<>();
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("pageSize", pageSize);
		if(code != 0){
			params.put("code", code);
		}
		if(type != 0) {
			params.put("type", type);
			
		}
		int totalSize = bannerImpl.selectTotal(params);
		List<BannerBean> beans = bannerImpl.selectBannersInPage(params);
		
		result.setData(beans);
		result.setTotalSize(totalSize);
		return result;
	}

	@Override
	public BannerBean getBannerById(String bid) {
		return bannerImpl.selectBannerById(bid);
	}

	@Override
	public List<BannerCodeBean> getCodeLists() {
		return bannerImpl.selectBannerCode();
	}

	@Override
	public BannerCodeBean getBannerCodeById(String cid) {
		return bannerImpl.selectBannerCodeById(cid);
	}

	@Override
	public boolean saveBanner(BannerBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getBid());
		if (isNew) {
			bean.setBid(AppTextUtil.getPrimaryKey());
			flag = bannerImpl.insertBanner(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = bannerImpl.updateBanner(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}


	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteBannerById(String id) throws ServiceException {
		boolean flag = false;
		flag = bannerImpl.deleteBannerById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}
	@Override
	public boolean saveBannerCode(BannerCodeBean bean) {
		boolean flag = false;
		if (bean == null)
			return false;

		boolean isNew = StringUtil.checkEmpty(bean.getCid());
		if (isNew) {
			bean.setCid(AppTextUtil.getPrimaryKey());
			flag = bannerImpl.insertBannerCode(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		} else {
			flag = bannerImpl.updateBannerCode(bean) > 0;
			if (!flag) {
				throw new ServiceException(RescodeConstants.getInstance().get("object_save_fail"));
			}
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteBannerCodeById(String id) {
		boolean flag = false;
		flag = bannerImpl.deleteBannerCodeById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}

}
