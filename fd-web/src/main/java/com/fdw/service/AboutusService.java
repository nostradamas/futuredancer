package com.fdw.service;

import java.util.List;

import com.fdw.model.AboutusBean;
import com.fdw.model.PageContentBean;

/**
 * 关于我们service层
 * 
 * @author nostr
 *
 */
public interface AboutusService {
	
	AboutusBean getContent();
	
	List<PageContentBean> getCultures(String aid);
	
}
