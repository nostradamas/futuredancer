package com.fdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.model.FooterBean;
import com.fdm.persist.dao.FooterDao;
import com.fdm.service.FooterService;
import com.fdm.service.exception.ServiceException;


@Service
public class FooterServiceImpl  implements FooterService {

	@Autowired
	FooterDao footerImpl;

	@Override
	public FooterBean getFooter() {
		return footerImpl.selectFooter();
	}

	@Override
	public boolean saveFooter(FooterBean bean) {
		return footerImpl.update(bean) > 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteFooterById(String id) {
		boolean flag = false;
		flag = footerImpl.deleteById(id) > 0;
		if (!flag) {
			new ServiceException("fail");
		}
		return flag;
	}


}
