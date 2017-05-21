package com.fdw.service;

import com.fdw.controller.res.ListResult;
import com.fdw.model.CoursePackBean;

public interface CoursePackService {

	ListResult<CoursePackBean> getCoursePackLists(Integer start, Integer length, String homeId);


}
