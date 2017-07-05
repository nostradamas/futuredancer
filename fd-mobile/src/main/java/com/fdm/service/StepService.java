package com.fdm.service;

import com.fdm.controller.res.ListResult;
import com.fdm.model.StepBean;

public interface StepService {

	ListResult<StepBean> getStepLists(Integer start, Integer length, String homeId);

	StepBean getStepById(String id);

	boolean saveStep(StepBean bean);

	boolean deleteStepById(String id);

}
