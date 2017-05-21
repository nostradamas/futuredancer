package com.fda.controller.req;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class EditBannerDetailParam {
	
	private String bid;
	private String title;// banner标题
	private String linkUrl;// 新闻内容

	@NotEmpty(message="内容链接不能为空")
	private String imgUrl;// 地址

	@Pattern(regexp="^\\d+$", message="选择正确的类型")
	private String bannerCode;
	
	@Pattern(regexp="^(1|2)$", message="选择正确的类型")
	private String type;
	
	private int sort;//顺序

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getBannerCode() {
		return bannerCode;
	}

	public void setBannerCode(String bannerCode) {
		this.bannerCode = bannerCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}


