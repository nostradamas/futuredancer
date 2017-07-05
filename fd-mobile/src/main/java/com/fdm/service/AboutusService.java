package com.fdm.service;

import com.fdm.controller.res.ListResult;
import com.fdm.model.AboutusBean;
import com.fdm.model.EnvironmentBean;


/**
 * 关于我们service层
 * 
 * @author nostr
 *
 */
public interface AboutusService {
	
	AboutusBean getAboutus();

	boolean saveAboutus(AboutusBean bean);

	//==================== 证书环境 ==========================
	
	ListResult<EnvironmentBean> getEnvironmentLists(Integer start, Integer length, int type);

	EnvironmentBean getEnvironmentById(String id);

	boolean saveEnvironment(EnvironmentBean bean);

	boolean deleteEnvironmentById(String id);
	
	
}
