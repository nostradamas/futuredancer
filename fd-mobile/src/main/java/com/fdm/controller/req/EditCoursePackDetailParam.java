package com.fdm.controller.req;

import org.hibernate.validator.constraints.NotEmpty;

public class EditCoursePackDetailParam {

	private String cid;

	@NotEmpty(message = "课程名称不能为空")
	private String name;
	private String brief;
	private String img;
	private int sort;
	@NotEmpty(message = "课程所属主页不能为空")
	private String homeId;
	
	private String teacher;// 教师

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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
}
