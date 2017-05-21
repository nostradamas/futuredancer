package com.fda.service;

import com.fda.controller.res.ListResult;
import com.fda.model.ClassIntroduceBean;

public interface ClassIntroduceService {

	ListResult<ClassIntroduceBean> getClassIntroduceLists(Integer start, Integer length);

	ClassIntroduceBean getClassIntroduceById(String id);

	boolean saveClassIntroduce(ClassIntroduceBean bean);

	boolean deleteClassIntroduceById(String id);

}
