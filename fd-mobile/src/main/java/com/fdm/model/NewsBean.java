package com.fdm.model;

import java.sql.Timestamp;

public class NewsBean {

	private String nid;
	private String title;// 新闻标题
	private String content;// 新闻内容
	private String brief;//　新闻简介
	private String img;// 新闻封面
	private String linkUrl;// 外链地址
	private Timestamp createTime;// 发布时间
	private String cid;// 新闻类型'
	private int sort;
	private int isTop;
	
	private String createCode;
	
	private NewsCategoryBean category;// 新闻分类

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public NewsCategoryBean getCategory() {
		return category;
	}

	public void setCategory(NewsCategoryBean category) {
		this.category = category;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}

	public String getCreateCode() {
		return createCode;
	}

	public void setCreateCode(String createCode) {
		this.createCode = createCode;
	}

	@Override
	public String toString() {
		return "NewsBean [nid=" + nid + ", title=" + title + ", content=" + content + ", brief=" + brief + ", img="
				+ img + ", linkUrl=" + linkUrl + ", createTime=" + createTime + ", cid=" + cid + ", category="
				+ category + "]";
	}

	
}
