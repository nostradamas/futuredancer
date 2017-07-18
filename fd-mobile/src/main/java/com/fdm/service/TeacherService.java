package com.fdm.service;

import com.fdm.controller.res.ListResult;
import com.fdm.controller.resmodel.ResTeacherBean;

/**
 * 授课教师service层
 * 
 * @author nostr
 *
 */
public interface TeacherService {

	ListResult<ResTeacherBean> getTeacherLists(Integer start, Integer length, int level, int targetId);

}
