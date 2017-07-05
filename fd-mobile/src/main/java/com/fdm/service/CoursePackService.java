package com.fdm.service;

import com.fdm.controller.res.ListResult;
import com.fdm.model.CoursePackBean;

public interface CoursePackService {

	ListResult<CoursePackBean> getCoursePackLists(Integer start, Integer length, String homeId);

	CoursePackBean getCoursePackById(String id);

	boolean saveCoursePack(CoursePackBean bean);

	boolean deleteCoursePackById(String id);

}
