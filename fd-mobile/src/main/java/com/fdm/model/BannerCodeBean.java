package com.fdm.model;

/**
 * 轮播图
 *
 */
public class BannerCodeBean {
	private String cid;
	private String name;// 标题名称
	private int bannerCode;// 关联code
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
	public int getBannerCode() {
		return bannerCode;
	}
	public void setBannerCode(int bannerCode) {
		this.bannerCode = bannerCode;
	}
}
