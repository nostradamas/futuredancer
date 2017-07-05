package com.fdm.model;

public class IndexContentBean {

	private String mid;
	private String homeId;// 关联首页
	private String name;// 标题名
	private String subName;// 显示二级名称
	private String brief;// 内容简介
	private String contentType;// 页面对应展示内容分类，1教师，2 学生 
	private String contentId;// 页面对应展示内容id
	private String background;// 背景
	private String icon;// tab图标
	private int sort;// 顺序
	private String subImg;// 展示页面小图
	
	
	private String homeName;// 主页名称
	private String url;// t跳转页面，，TODO:删

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getHomeId() {
		return homeId;
	}

	public void setHomeId(String homeId) {
		this.homeId = homeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getSubImg() {
		return subImg;
	}

	public void setSubImg(String subImg) {
		this.subImg = subImg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHomeName() {
		return homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
}
