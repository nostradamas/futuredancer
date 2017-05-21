package com.fdw.persist.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fdw.model.BannerBean;
import com.fdw.persist.dao.BannerDao;

@Repository
public class BannerImpl extends BaseImpl  implements BannerDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".BannerMapper";

	@Override
	public List<BannerBean> selectBanners(String code) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectBannerByCode", code);
	}

}
