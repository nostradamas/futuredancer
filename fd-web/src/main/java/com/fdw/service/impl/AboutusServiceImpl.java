package com.fdw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.model.AboutusBean;
import com.fdw.model.PageContentBean;
import com.fdw.persist.dao.AboutusDao;
import com.fdw.persist.dao.PageContentDao;
import com.fdw.service.AboutusService;

@Service
public class AboutusServiceImpl  implements AboutusService {
	
	@Autowired
	PageContentDao pageContentImpl;
	
	@Autowired
	AboutusDao aboutusImpl;
	
	@Override
	public AboutusBean getContent() {
		return aboutusImpl.selectContent();
	}

	@Override
	public List<PageContentBean> getCultures(String aid) {
		return pageContentImpl.selectPageContents(aid);
	}

}
