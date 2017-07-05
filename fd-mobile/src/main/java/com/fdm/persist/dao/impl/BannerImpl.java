package com.fdm.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdm.model.BannerBean;
import com.fdm.model.BannerCodeBean;
import com.fdm.persist.dao.BannerDao;


@Repository
public class BannerImpl extends BaseImpl  implements BannerDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".BannerMapper";

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public List<BannerBean> selectBannersInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectBannersInPage",params);
	}

	@Override
	public BannerBean selectBannerById(String bid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectBannerById", bid);
	}

	@Override
	public List<BannerCodeBean> selectBannerCode() {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectBannerCode");
	}

	@Override
	public int insertBanner(BannerBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertBanner", bean);
	}

	@Override
	public int updateBanner(BannerBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".updateBanner", bean);
	}

	@Override
	public int deleteBannerById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteBannerById", id);
	}

	@Override
	public BannerCodeBean selectBannerCodeById(String cid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectBannerCodeById", cid);
	}

	@Override
	public int insertBannerCode(BannerCodeBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertBannerCode", bean);
	}

	@Override
	public int updateBannerCode(BannerCodeBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".updateBannerCode", bean);
	}

	@Override
	public int deleteBannerCodeById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteBannerCodeById", id);
	}

}
