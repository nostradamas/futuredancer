package com.fdw.model;

public class TeacherBean {

	private String tid;
	private String name;// 姓名
	private String brief;// 简介
	private String detail;// 详情
	private String img;// 封面
	private String icon;// 头像
	private int type;// 教师类型
	private int sort;// 排序
	private String homeId;// 关联主页id

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getHomeId() {
		return homeId;
	}

	public void setHomeId(String homeId) {
		this.homeId = homeId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "TeacherBean [tid=" + tid + ", name=" + name + ", brief=" + brief + ", img=" + img + ", icon=" + icon
				+ ", type=" + type + ", sort=" + sort + ", homeId=" + homeId + "]";
	}

}
