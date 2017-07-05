package com.fdm.persist.dao;

import java.util.List;
import java.util.Map;

import com.fdm.model.StepBean;


/**
 * 超链接数据层
 * @author nostr
 *
 */
public interface StepDao {

	List<StepBean> selectStepsInPage(Map<String, Object> params);

	int selectTotal(Map<String, Object> params);

	StepBean selectStepById(String id);

	int insert(StepBean bean);

	int update(StepBean bean);

	int deleteById(String id);

}
