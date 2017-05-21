package com.fda.controller.req;

import org.hibernate.validator.constraints.NotEmpty;

public class EditNewsCategoryParam {
	private String cid;
	@NotEmpty(message="分类名称不能为空")
	private String name;// 分类名称
	
	private int sort;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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
