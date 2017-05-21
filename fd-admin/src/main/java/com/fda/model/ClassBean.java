package com.fda.model;

import java.sql.Timestamp;

public class ClassBean {
	private String cid;
	private String name;// 内容名称
	private String videoUrl;// 课程视频
	private int viewNum;// 浏览次数
	private String img;// 视频封面
	private long time;// 视频时长
	private String brief;// 简介
	private int sort;// 顺序
	private String homeId;// 首页id
	private Timestamp createTime;// 视频

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

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public int getViewNum() {
		return viewNum;
	}

	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getHomeId() {
		return homeId;
	}

	public void setHomeId(String homeId) {
		this.homeId = homeId;
	}

	@Override
	public String toString() {
		return "ClassBean [cid=" + cid + ", name=" + name + ", videoUrl=" + videoUrl + ", viewNum=" + viewNum + ", img="
				+ img + ", time=" + time + ", brief=" + brief + ", sort=" + sort + ", createTime=" + createTime + "]";
	}

}
