package com.fdm.service;

import com.fdm.controller.res.ListResult;
import com.fdm.model.ClassIntroduceBean;

public interface ClassIntroduceService {

	ListResult<ClassIntroduceBean> getClassIntroduceLists(Integer start, Integer length);

	ClassIntroduceBean getClassIntroduceById(String id);

	boolean saveClassIntroduce(ClassIntroduceBean bean);

	boolean deleteClassIntroduceById(String id);

}
