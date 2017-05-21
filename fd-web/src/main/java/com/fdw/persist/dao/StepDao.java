package com.fdw.persist.dao;

import java.util.List;

import com.fdw.model.StepBean;



/**
 * 阶段数据层
 * @author nostr
 *
 */
public interface StepDao {

	List<StepBean> selectSteps(String hid);

}
