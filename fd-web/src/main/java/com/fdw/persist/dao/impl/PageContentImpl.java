package com.fdw.persist.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fdw.model.PageContentBean;
import com.fdw.persist.dao.PageContentDao;

@Repository
public class PageContentImpl extends BaseImpl implements PageContentDao {

	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".PageContentMapper";

	@Override
	public List<PageContentBean> selectPageContents(String homeId) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectPageContentByHid", homeId);
	}


}
