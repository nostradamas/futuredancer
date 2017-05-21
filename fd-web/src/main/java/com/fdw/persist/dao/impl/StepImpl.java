package com.fdw.persist.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fdw.model.StepBean;
import com.fdw.persist.dao.StepDao;


@Repository
public class StepImpl extends BaseImpl  implements StepDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".StepMapper";

	@Override
	public List<StepBean> selectSteps(String hid) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectSteps", hid);
	}
	

}
