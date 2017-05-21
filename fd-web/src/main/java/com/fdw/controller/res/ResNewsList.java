package com.fdw.controller.res;

public class ResNewsList {
	private String nid;
	private String title;// 新闻标题
	private String brief;// 新闻简介
	private String img;// 新闻封面
	private String createTime;// 发布时间

	private String createCode;// 发布时间
	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateCode() {
		return createCode;
	}

	public void setCreateCode(String createCode) {
		this.createCode = createCode;
	}

	@Override
	public String toString() {
		return "ResNewsList [nid=" + nid + ", title=" + title + ", brief=" + brief + ", img=" + img + ", createTime="
				+ createTime + "]";
	}

}
