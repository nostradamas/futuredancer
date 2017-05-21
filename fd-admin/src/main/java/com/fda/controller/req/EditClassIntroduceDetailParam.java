package com.fda.controller.req;

import org.hibernate.validator.constraints.NotEmpty;

public class EditClassIntroduceDetailParam {

	private String cid;
	private String tabId;
	@NotEmpty(message = "课程名称不能为空")
	private String name;
	private int sort;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTabId() {
		return tabId;
	}
	public void setTabId(String tabId) {
		this.tabId = tabId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}

}
