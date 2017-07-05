package com.fdm.service;

import com.fdm.controller.res.ListResult;
import com.fdm.model.LinkBean;

public interface LinkService {

	ListResult<LinkBean> getLinkLists(Integer start, Integer length);

	LinkBean getLinkById(String id);

	boolean saveLink(LinkBean bean);

	boolean deleteLinkById(String id);

}
