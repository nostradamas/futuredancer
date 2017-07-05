package com.fdm.controller.req;

import org.hibernate.validator.constraints.NotEmpty;

public class EditLinkDetailParam {
	private String lid;
	@NotEmpty(message="链接名称不能为空")
	private String linkName;

	@NotEmpty(message="链接地址不能为空")
	private String linkUrl;
	
	private String img;
	private int sort;
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
