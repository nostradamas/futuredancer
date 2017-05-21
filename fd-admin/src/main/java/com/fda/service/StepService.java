package com.fda.service;

import com.fda.controller.res.ListResult;
import com.fda.model.StepBean;

public interface StepService {

	ListResult<StepBean> getStepLists(Integer start, Integer length, String homeId);

	StepBean getStepById(String id);

	boolean saveStep(StepBean bean);

	boolean deleteStepById(String id);

}
