package com.fda.model;

public class StudentBean {

	private String sid;
	private String name;// 姓名
	private String brief;// 简介
	private String img;// 封面
	private String classId;// 关联课程
	private String homeId;// 关联页面code
	private String detail;
	private int sort;// 排序
	
	private int atHome;// 是否显示在首页1 显示 2 未显示
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
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
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
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
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getAtHome() {
		return atHome;
	}
	public void setAtHome(int atHome) {
		this.atHome = atHome;
	}

}
