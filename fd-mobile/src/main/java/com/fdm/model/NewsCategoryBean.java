package com.fdm.model;

public class NewsCategoryBean {
	
	private String cid;
	private String name;
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
	@Override
	public String toString() {
		return "NewsCategoryBean [cid=" + cid + ", name=" + name + ", sort=" + sort + "]";
	}
	
}
