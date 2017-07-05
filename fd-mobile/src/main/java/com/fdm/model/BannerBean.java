package com.fdm.model;

/**
 * 轮播图
 *
 */
public class BannerBean {
	private String bid;
	private String title;// 标题名称
	private String linkUrl;// 链接地址
	private String imgUrl;// 图片地址
	private int sort;// 排序
	private int bannerCode;// 关联code
	private int type;// 显示类型：1图片，2视频
	
	private BannerCodeBean code;

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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getBannerCode() {
		return bannerCode;
	}

	public void setBannerCode(int bannerCode) {
		this.bannerCode = bannerCode;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public BannerCodeBean getCode() {
		return code;
	}

	public void setCode(BannerCodeBean code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "BannerBean [bid=" + bid + ", title=" + title + ", linkUrl=" + linkUrl + ", imgUrl=" + imgUrl + ", sort="
				+ sort + ", bannerCode=" + bannerCode + ", type=" + type + "]";
	}

}
