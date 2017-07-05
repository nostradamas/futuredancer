package com.fdm.service;

import com.fdm.model.FooterBean;

public interface FooterService {

	boolean saveFooter(FooterBean bean);

	boolean deleteFooterById(String id);

	FooterBean getFooter();

}
