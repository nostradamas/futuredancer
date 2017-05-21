package com.fdw.persist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fdw.model.ClassIntroduceBean;
import com.fdw.persist.dao.ClassIntroduceDao;


@Repository
public class ClassIntroduceImpl extends BaseImpl  implements ClassIntroduceDao{


	public static final String NAME_SPACE = NAME_SPACE_HEADER + ".ClassIntroduceMapper";

	@Override
	public List<ClassIntroduceBean> selectClassIntroducesByTabId(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectClassIntroducesByTabId",params);
	}
	

}
