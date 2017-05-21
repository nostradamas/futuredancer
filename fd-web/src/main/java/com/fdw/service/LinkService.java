package com.fdw.service;

import com.fdw.controller.res.ListResult;
import com.fdw.model.LinkBean;

public interface LinkService {

	ListResult<LinkBean> getLinkLists();

}
