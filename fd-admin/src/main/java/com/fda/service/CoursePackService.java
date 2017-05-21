package com.fda.service;

import com.fda.controller.res.ListResult;
import com.fda.model.CoursePackBean;

public interface CoursePackService {

	ListResult<CoursePackBean> getCoursePackLists(Integer start, Integer length, String homeId);

	CoursePackBean getCoursePackById(String id);

	boolean saveCoursePack(CoursePackBean bean);

	boolean deleteCoursePackById(String id);

}
