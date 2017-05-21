package com.fdw.model;

import java.util.List;

public class HomeBean {

	private String hid;
	private String name;// 名称
	private String parentId;// 父页面code
	private int isLeaf;// 子节点。是否是子节点，0否 1是。是则没有tab页
	private int isShow;// 是否显示，1显示 0 不显示
	private int bannerCode;// 关联Banner
	private int sort;// 顺序
	
	
	
	private int isVoid;// 禁止进入
	
	private int active;

	private List<HomeBean> subTabs;

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(int isLeaf) {
		this.isLeaf = isLeaf;
	}

	public int getBannerCode() {
		return bannerCode;
	}

	public void setBannerCode(int bannerCode) {
		this.bannerCode = bannerCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public List<HomeBean> getSubTabs() {
		return subTabs;
	}

	public void setSubTabs(List<HomeBean> subTabs) {
		this.subTabs = subTabs;
	}

	public int getIsShow() {
		return isShow;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	public int getIsVoid() {
		return isVoid;
	}

	public void setIsVoid(int isVoid) {
		this.isVoid = isVoid;
	}

	@Override
	public String toString() {
		return "HomeBean [hid=" + hid + ", name=" + name + ", parentId=" + parentId + ", isLeaf=" + isLeaf + ", isShow="
				+ isShow + ", bannerCode=" + bannerCode + ", sort=" + sort + ", subTabs=" + subTabs + "]";
	}
}
