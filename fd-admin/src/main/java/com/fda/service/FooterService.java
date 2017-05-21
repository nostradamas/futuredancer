package com.fda.service;

import com.fda.model.FooterBean;

public interface FooterService {

	boolean saveFooter(FooterBean bean);

	boolean deleteFooterById(String id);

	FooterBean getFooter();

}
