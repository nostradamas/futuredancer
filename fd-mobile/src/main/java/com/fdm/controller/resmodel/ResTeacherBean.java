package com.fdm.controller.resmodel;

import com.fdm.model.enumModel.Teacher_direction;

public class ResTeacherBean {

	private String tid;
	private String name;// 姓名
	private String brief;// 简介
	private String detail;// 详情
	private String img;// 封面
	private int level;// 教师类型1明星老师，2总监级别，3高级教师，4普通教师
	private int direction;// 教学方向1中国舞，2芭蕾舞，3拉丁舞，4编导，5国际标准舞
	private int targetId;// 关联主页id
	
	private String tag;// 

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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public String getTag() {
		return tag;
	}

	/*public void setTag(String tag) {
		this.tag = tag;
	}*/

	public void setTag(int direction) {
		String directions = Teacher_direction.getName(direction);
		this.tag = directions;
	}
	
}
