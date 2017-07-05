package com.fdm.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdm.model.StepBean;
import com.fdm.persist.dao.StepDao;

@Repository
public class StepImpl extends BaseImpl  implements StepDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".StepMapper";

	@Override
	public List<StepBean> selectStepsInPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectStepsInPage",params);
	}

	@Override
	public int selectTotal(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectTotal", params);
	}

	@Override
	public StepBean selectStepById(String id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectStepById", id);
	}

	@Override
	public int insert(StepBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

	@Override
	public int update(StepBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".update", bean);
	}

	@Override
	public int deleteById(String id) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteById", id);
	}
	

}
