package com.fda.service;

import com.fda.controller.res.ListResult;
import com.fda.model.LinkBean;

public interface LinkService {

	ListResult<LinkBean> getLinkLists(Integer start, Integer length);

	LinkBean getLinkById(String id);

	boolean saveLink(LinkBean bean);

	boolean deleteLinkById(String id);

}
